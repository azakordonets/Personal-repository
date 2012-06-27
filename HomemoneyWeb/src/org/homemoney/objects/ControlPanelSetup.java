package org.homemoney.objects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ControlPanelSetup extends Base{
	
	protected void clickCheckBoxById(String id){
		clickById(id);	
		waitForElementById(id);
		
	}
	
	public void clickIncludeBalanceCheckBox (String accName, boolean action){
		/* if state is true - means that we want to select unselected checkbox
		 * if state is false - means we want to deselect selected checkbox
		 */
		List<WebElement> allAccounts = findElementsByCss(".accsettingsitem");
		for (WebElement accEl: allAccounts){
			WebElement accountName = accEl.findElement(By.cssSelector("[style=\"float: left; width: 300px; font-size: 120%;\"]"));
			if (accountName.getText().equals(accName)){
				WebElement CheckBoxe = accEl.findElement(By.cssSelector("span[property=\"IncludeInBalance\"] input"));
				 String id = CheckBoxe.getAttribute("id");
				 boolean checkBoxstate = isElementSelectedById(id);
				 if (action == true & checkBoxstate == true){
					 System.out.println("Checkbox is already selected");
				 }else if (action == false & checkBoxstate == true){
					 clickCheckBoxById(id);
					 break;
				 }else if (action == true & checkBoxstate == false){
				 clickCheckBoxById(id);
				 break;
				 }else if (action == false & checkBoxstate == false){
					 System.out.println("Checkbox is already deselected");
				 }
				break;
			}
		}
	}
	
	public void clickDisplayOnDashboardCheckBox (String accName, boolean action){
		/* if state is true - means that we want to select unselected checkbox
		 * if state is false - means we want to deselect selected checkbox
		 */
		List<WebElement> allAccounts = findElementsByCss(".accsettingsitem");
		for (WebElement accEl: allAccounts){
			WebElement accountName = accEl.findElement(By.cssSelector("[style=\"float: left; width: 300px; font-size: 120%;\"]"));
			if (accountName.getText().equals(accName)){
				WebElement CheckBoxe = accEl.findElement(By.cssSelector("span[property=\"DisplayOnDashBoard\"] input"));
				 String id = CheckBoxe.getAttribute("id");
				 boolean checkBoxstate = isElementSelectedById(id);
				 if (action == true & checkBoxstate == true){
					 System.out.println("Checkbox is already selected");
				 }else if (action == false & checkBoxstate == true){
					 clickCheckBoxById(id);
				 }else if (action == true & checkBoxstate == false){
				 clickCheckBoxById(id);
				 }else if (action == false & checkBoxstate == false){
					 System.out.println("Checkbox is already deselected");
				 }
				break;
			}
		}
		
	}
	
	
	public void clickBackToControlPanelLink(){
		List<WebElement> links = findElementsByCss("#page a[href=\"Default.aspx\"]");
		links.get(0).click();
	}
	

}

