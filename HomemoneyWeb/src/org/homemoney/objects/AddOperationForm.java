package org.homemoney.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.selenesedriver.IsElementSelected;

public class AddOperationForm extends Base{
	
	protected void clickAccount (String Name){
		clickByCss("#OperationAdd_account_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("#OperationAdd_account_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("#OperationAdd_account_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void clickTransferAccount (String Name){
		clickByCss("#OperationAdd_accountTrans_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("#OperationAdd_accountTrans_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("#OperationAdd_accountTrans_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void clickCurrency (String Name){
		clickByCss("#OperationAdd_currency_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("#OperationAdd_currency_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("#OperationAdd_currency_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void clickTranserCurrency (String Name){
		clickByCss("OperationAdd_currencyTrans_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("OperationAdd_currencyTrans_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("OperationAdd_currencyTrans_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void enterSum (String sum){
		clickById("OperationAdd_total");
		sendKeyById("OperationAdd_total", sum);
	}
	
	protected void enterTransferSum (String sum){
		if (isElementDisplayedById("OperationAdd_totalTrans")){
			clickById("OperationAdd_totalTrans");
			sendKeyById("OperationAdd_totalTrans", sum);	
		}
	}
	
	protected void enterDate (String date){
		clickById("OperationAdd_date");
		clearById("OperationAdd_date");
		sendKeyById("OperationAdd_date", date);
	}
	
	
	protected void clickExpenceCategory (String Name){
		clickByCss("#OperationAdd_categoryExp_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("#OperationAdd_categoryExp_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("#OperationAdd_categoryExp_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void clickIncomeCategory (String Name){
		clickByCss("#OperationAdd_categoryInc_chzn a");
		WebElement Account = null;
		List<WebElement> accountsList = driver.findElements(By.cssSelector("#OperationAdd_categoryInc_chzn li"));
		for (WebElement el: accountsList){			
			if (Name.equals(el.getText())){
				Account = el;
				String id = Account.getAttribute("id");
				driver.findElement(By.cssSelector("#OperationAdd_categoryInc_chzn li[id="+id+"]")).click();		
				break;
				}
			}
		}
	
	protected void enterComment(String comment){
		clickById("OperationAdd_description");
		sendKeyById("OperationAdd_description", comment);
	}
	
	protected void clickPlanButton(){
		clickById("OperationAdd_plan");
	}
	
	protected void disablePlanButton(){
		if (isElementSelectedById("OperationAdd_plan")){
			clickPlanButton();
		}
	}
	
	protected void setPlanOption (boolean state){
		disablePlanButton();
		if (state){
			clickPlanButton();
		}
	}
	
	protected void clickAddButton(){
		clickById("OperationAdd_btnAdd");
	}
	
	public void clickExpenseTab(){
		clickByCss("#OperationAdd a[rel=\"expence\"]");
	}
	
	public void clickTransferTab(){
		clickByCss("#OperationAdd a[rel=\"transfer\"]");
	}
	
	public void clickIncomeTab(){
		clickByCss("#OperationAdd a[rel=\"income\"]");
	}
	
	public void addExpenceOperation(String account, String currency, String sum, String date, String category, String comment, boolean plan) {
		clickAccount(account);
		clickCurrency(currency);
		enterSum(sum);
		enterDate(date);
		clickExpenceCategory(category);
		enterComment(comment);
		setPlanOption(plan);
		clickAddButton();
		
	}
	
	public void addTransferOperation(String account, String transferAccount, String currency, String transferCurrency,  String sum, String transferSum, String date,String comment, boolean plan) {
		clickTransferTab();
		clickAccount(account);
		clickCurrency(currency);
		enterSum(sum);
		clickTransferAccount(transferAccount);
		if (!currency.equals(transferCurrency)){
		clickTranserCurrency(transferCurrency);
		enterTransferSum(transferSum);
		}
		enterDate(date);
		enterComment(comment);
		clickAddButton();
		
	}
	
	public void addIncomeOperation(String account, String currency, String sum, String date, String category, String comment) {
		clickIncomeTab();
		clickAccount(account);
		clickCurrency(currency);
		enterSum(sum);
		enterDate(date);
		clickIncomeCategory(category);
		enterComment(comment);
		clickAddButton();
		
	}

}