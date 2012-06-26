package org.homemoney.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.bcel.verifier.statics.IntList;
import org.homemoney.objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class TestControlPanel {
		
		ControlPanel cp = new ControlPanel ();
		AddOperationForm ops = new AddOperationForm();
		@Before
		public void initialize(){
			cp.setUp();
			ops.MainLogin("testhome", "homemoney");	
		}
		
		@Test @Ignore
		public void checkAccountNameClick() throws Exception {
			cp.clickByLinkText("New account");
			assertEquals("New account",cp.getTextByCss("#account_view_filter_select_account_chzn > a.chzn-single > span"));
		}
		
		
		
		
		@Test @Ignore
		public void addExpenceOperation () throws InterruptedException{	
			String expence = cp.generateNumberIntoString(1000);
			String account = "Наличные деньги";
			String currency = "UAH";
			Float initialAccountSum = null;
			Float finalAccountSum = null;
			initialAccountSum = cp.getAccountBalanceValue(account, currency);
			ops.addExpenceOperation(account,currency,expence,cp.getCurrentDate(),"Жилье","expence test comment "+expence+"",false);
			Thread.sleep(3000);
			finalAccountSum = cp.getAccountBalanceValue(account, currency);
			assertTrue(initialAccountSum - cp.convertStringToFloat(expence) == finalAccountSum);
			cp.deleteAllOperationsInTodaysOperationsSection();	
		}
		
		@Test @Ignore
		public void addExpenceUsingSearchOperation () throws InterruptedException{	
			String expence = cp.generateNumberIntoString(1000);
			String account = "Наличные деньги";
			String currency = "UAH";
			Float initialAccountSum = null;
			Float finalAccountSum = null;
			initialAccountSum = cp.getAccountBalanceValue(account, currency);
			ops.addExpenceUsingCategorySearchOperation(account,currency,expence,cp.getCurrentDate(),"Жилье","expence test comment "+expence+"",false);
			Thread.sleep(3000);
			finalAccountSum = cp.getAccountBalanceValue(account, currency);
			assertTrue(initialAccountSum - cp.convertStringToFloat(expence) == finalAccountSum);
			cp.deleteAllOperationsInTodaysOperationsSection();	
		}
		
		@Test @Ignore
		public void addIncomeOperation () throws InterruptedException{
			String income = cp.generateNumberIntoString(1000);
			String account = "New account";
			String currency = "UAH";
			Float initialAccountSum = null;
			Float finalAccountSum = null;
			initialAccountSum = cp.getAccountBalanceValue(account, currency);
			ops.addIncomeOperation(account,currency,income,cp.getCurrentDate(),"Зарплата","another income test comment"+income+"");
			Thread.sleep(3000);
			finalAccountSum = cp.getAccountBalanceValue(account, currency);
			assertTrue(finalAccountSum - cp.convertStringToFloat(income) == initialAccountSum);
			cp.deleteAllOperationsInTodaysOperationsSection();
			
		}
		
		@Test @Ignore
		public void addTransferOperation () throws InterruptedException{
			String transferSum = cp.generateNumberIntoString(1000);
			String fromAccount = "Наличные деньги";
			String toAccount = "New account";
			String currency = "UAH";
			Float fromInitialAccountSum = null;
			Float toInitialAccountSum = null;
			Float fromFinalAccountSum = null;
			Float toFinalAccountSum = null;
			fromInitialAccountSum = cp.getAccountBalanceValue(fromAccount, currency);
			toInitialAccountSum = cp.getAccountBalanceValue(toAccount, currency);
			ops.addTransferOperation(fromAccount, toAccount, currency, currency, transferSum, transferSum, cp.getCurrentDate(), "another transfer test comment"+transferSum+"", false);
			Thread.sleep(3000);
			fromFinalAccountSum = cp.getAccountBalanceValue(fromAccount, currency);
			toFinalAccountSum = cp.getAccountBalanceValue(toAccount, currency);
			assertTrue(toFinalAccountSum - cp.convertStringToFloat(transferSum) == toInitialAccountSum);
			assertTrue(fromInitialAccountSum - cp.convertStringToFloat(transferSum) ==  fromFinalAccountSum);
			cp.deleteAllOperationsInTodaysOperationsSection();
			
		}
		
		@Test @Ignore
		public void addMultiCurrencyTransferOperation () throws InterruptedException{
			String transferSumFrom = cp.generateNumberIntoString(1000);
			String transferSumTo = cp.generateNumberIntoString(1000);
			String fromAccount = "New account";
			String toAccount = "Наличные деньги";
			String fromCurrency = "UAH";
			String toCurrency = "EUR";
			Float fromInitialAccountSum = null;
			Float toInitialAccountSum = null;
			Float fromFinalAccountSum = null;
			Float toFinalAccountSum = null;
			fromInitialAccountSum = cp.getAccountBalanceValue(fromAccount, fromCurrency);
			toInitialAccountSum = cp.getAccountBalanceValue(toAccount, toCurrency);
			ops.addTransferOperation(fromAccount, toAccount, fromCurrency, toCurrency, transferSumFrom, transferSumTo, cp.getCurrentDate(), "another transfer test comment from: "+transferSumFrom+" to:"+transferSumTo+"", false);
			Thread.sleep(3000);
			fromFinalAccountSum = cp.getAccountBalanceValue(fromAccount, fromCurrency);
			toFinalAccountSum = cp.getAccountBalanceValue(toAccount, toCurrency);
			assertTrue(toFinalAccountSum - cp.convertStringToFloat(transferSumTo) == toInitialAccountSum);
			assertTrue(fromInitialAccountSum - cp.convertStringToFloat(transferSumFrom) ==  fromFinalAccountSum);
			cp.deleteAllOperationsInTodaysOperationsSection();
			
		}
		@Test @Ignore
		public void collapseAccountCategorySection(){
			
			int beforeClick = cp.getCountOfVisibleAccountsInCategorySections();
			cp.clickAccountCategoryElement("Наличные");
			int afterClick = cp.getCountOfVisibleAccountsInCategorySections();
			assertTrue(beforeClick - afterClick == 1);
		}
		
		@Test @Ignore
		public void checkCategoryTotalBalance(){
			assertEquals(cp.countFirstCategoryAccountsSumOfMoney(), cp.getFirstCategorieTotalSumValue(),0.05);
		}
		
		@Test @Ignore
		public void checkTodaysOperations() throws InterruptedException{
			cp.waitUntilTodaysTransactionsIsNotLoaded();
			
			
		}
		
		@After
		public void finilize(){
			ops.tearDown();
		}
		
	
		
}