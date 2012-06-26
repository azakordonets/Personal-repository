package org.homemoney.objects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ControlPanel extends Base{

public Float getSumValue(String value){
	String sumWithComa = value.replaceAll("[A-Z ]*", "");
	String finalValue = sumWithComa.replaceAll("\\p{Z}", "");
	String finalSum = finalValue.replaceAll(",", "");
	Float endSum = new Float(finalSum);
	return endSum;		
}
	
protected String getCurrencyValue (String value){
	String currencyWithDot = value.replaceAll("[0-9 ],*","");
	String currency = currencyWithDot.replaceAll("^.", "");
	return currency;
}

protected List<String> getAccountDetails(String AccName) {
	List<WebElement> allAccounts = findElementsByCss("div[class=\"account\"]");// list of all accounts		
	List<String> balanceList = new ArrayList<String>();//list where we will store all found balance values
	for (WebElement el: allAccounts){
		if (el.findElement(By.cssSelector(".name.inv")).getText().equals(AccName)){ //css for acount name
			List<WebElement> allBalances = el.findElements(By.cssSelector("div[class=\"balance positive\"]"));//list where we store balance values of the el Element
			for (WebElement bal: allBalances){
				balanceList.add(bal.getText());	    
				}
		}
				
		}
	return balanceList;
	}

	public Float getAccountBalanceValue (String AccountName, String currency){
		List<String> accountsList = getAccountDetails(AccountName);
		Float AccountBalance = (float) 0.0;
		if (accountsList.size() == 1){
		AccountBalance = getSumValue(accountsList.get(0));
		}else {
			for (String el : accountsList){
				if (getCurrencyValue(el).equals(currency)){
					AccountBalance = getSumValue(el);
				}
			}
		}
		
		return AccountBalance;	
}
	
	public float getFirstCategorieTotalSumValue(){
		List<WebElement> CategoriesSums = findElementsByCss(".account-group-balance span:first-child");
		return getSumValue(CategoriesSums.get(0).getText());
		
	}

	public int getCountOfVisibleAccountsInCategorySections(){
		List<WebElement> beforeAllAccounts = findElementsByCss(".account-group-content");// list of all categories		
		int counter = 0;
		for (WebElement el: beforeAllAccounts){
			if (el.isDisplayed()){ 
				counter++;
			}
		}
		return counter;
	}
	
	public float getCurrentDateStartingBalance(){
		String startBalanceValue = findElementByCss("#ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_balance_start > .operation_view_last_transactions_balance_start_sum").getText();
		float result;
		try {
			result = convertCurrentDateBalanceToFloat(startBalanceValue);
		} catch (NumberFormatException nfe){
			result = (float) 0.0;
		}
		return result;
	}
	
	public float getCurrentDateEndBalance(){
		float result;
		String endBalanceValue = findElementByCss("#ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_balance_end > .operation_view_last_transactions_balance_end_sum").getText();
		
		try {
			result = convertCurrentDateBalanceToFloat(endBalanceValue);
		}catch(NumberFormatException nfe){
		result = (float) 0.0;
		}
		
		return result;
	}
	
	public float convertCurrentDateBalanceToFloat(String value){
		Float result = new Float (value.replaceAll("[,]?[A-Z ]*",""));
		return result;
	}
	
	public void waitUntilTodaysTransactionsIsNotLoaded() throws InterruptedException{
		//Thread.sleep(5000);
		while(!isElementDisplayedByCss("#ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_balance_start > .operation_view_last_transactions_balance_start_sum")){		
		Thread.sleep(3000);
		}
	}
	
	public boolean isNoTransactionsTextIsDisplayed(){
		boolean result;
		if (isElementDisplayedByCss("#ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_no_transactions")){
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	public String getTodaysOpsCategoryName(String name){
		List<WebElement> categoriesList = findElementsByCss("#ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_last_transactions .operation_view_last_item_info:first-child span.operation_view_last_item_category.ellipsis");
		String result = null;
		for (WebElement el:categoriesList){
			String categoryName = el.getText();
			if (categoryName.replaceAll("\\p{L}*\\p{P}", "").equals(name)){
				 result = categoryName.replaceAll("\\p{L}*\\p{P}", "");
			}
		}
		return result;
	}
	
	public void deleteAllOperationsInTodaysOperationsSection(){
		List<WebElement> deleteButtons = findElementsByCss("a.ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_delete");
		for(WebElement el:deleteButtons){
			el.click();
			Alert alert = driver.switchTo().alert();  
            alert.accept(); 
             
    } 

		}
	

	public float countFirstCategoryAccountsSumOfMoney(){
		float totalMoney = 0;
		List<WebElement> allAccounts = findElementsByCss(".account-group:first-child .balance.positive #acc_balance");
		for (WebElement el:allAccounts){
			String value = el.getAttribute("title");
		Float elMoneyValue = getSumValue(value);
		totalMoney += elMoneyValue;
		}
		return totalMoney;
	}
	
	public void clickAccountCategoryElement (String name){
		List<WebElement> allCategories = findElementsByCss(".account-group-title h3");// list of all categories		
		for (WebElement el: allCategories){
			if (el.getText().equals(name)){ 
				el.click();
				break;
				}
			}
	}
	public void clickAllForTodayOperationsButton(){
		clickById("ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_state_all");
	}
	
	public void clickTodaysOpsForCurrentAccAndCurrency(){
		clickById("ctl00_ctl00_Main_Main_DashBoardViewOperations1_LastOperationByDate_state_byAcc");
	}
	
	protected void clickTodaysTransactiosnTab(){
		clickByCss("a[rel=\"byDate\"]");
	}
	
	protected void clickLastChangedTab(){
		clickByCss("a[rel=\"last\"]");
	}
	
	protected void clickPlannedTab(){
		clickByCss("a[rel=\"plan\"]");
	}
	
	protected void clickTemplatesTab(){
		clickByCss("a[rel=\"template\"]");
	}
	
	
	
	}
	


		
	
