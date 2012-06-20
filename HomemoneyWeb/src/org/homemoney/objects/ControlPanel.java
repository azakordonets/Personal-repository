package org.homemoney.objects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ControlPanel extends Base{

protected Float getSumValue(String value){
	String sumWithComa = value.replaceAll("[A-Z ]*", "");
	String finalSum = sumWithComa.replaceAll(",", ".");
	Float endSum = new Float(finalSum);
	return endSum;		
}
	
protected String getCurrencyValue (String value){
	String currency = value.replaceAll("[0-9 ],*","");
	return currency;
}

protected List<String> getAccountDetails(String AccName) {
	List<WebElement> allAccounts = driver.findElements(By.cssSelector("div[class=\"account\"]"));// list of all accounts		
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
	
	public WebElement getAccountCategoryElement (String name){
		List<WebElement> allCategories = driver.findElements(By.cssSelector(".account-group-title h3"));// list of all categories		
		WebElement result = null;
		for (WebElement el: allCategories){
			if (el.getText().equals(name)){ 
				result = el;
				break;
				}
			}
		return result;
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
	


		
	
