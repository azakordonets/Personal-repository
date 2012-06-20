package org.homemoney.objects;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	public String baseUrl;
	public WebDriverBackedSelenium selenium;
	
	public void setUp()  {
		driver = new FirefoxDriver();
		baseUrl = "http://dev.homemoney.com.ua/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		getURL("/#");
	}
	
	public void MainLogin (String login, String password){
		clickById("login-nav-signin");
		clearById("ctl00_Main_rl1_hmLogin_login");
		sendKeyById("ctl00_Main_rl1_hmLogin_login", login);
		clearById("ctl00_Main_rl1_hmLogin_password");
		sendKeyById("ctl00_Main_rl1_hmLogin_password", password);
		clickById("ctl00_Main_rl1_hmLogin_LoginButton");
	}
	
	public void TopLogin (String login, String password){
		clickById("ctl00_LoginView1_A2");
		clearById("ctl00_Main_hmLogin_login");
		sendKeyById("ctl00_Main_hmLogin_login", login);
		clearById("ctl00_Main_hmLogin_password");
		sendKeyById("ctl00_Main_hmLogin_password", password);
		clickById("ctl00_Main_hmLogin_LoginButton");
	}
	
	public void logout (){
		driver.findElement(By.id("ctl00_ctl00_Top_LV2_LoginStatus2")).click();
	}
	
	public String getLoginName (){
		String login = driver.findElement(By.id("ctl00_ctl00_Top_LV2_LoginName1")).getText();
		return login;
	}
	
	public String getElementByLinkText (String name){
		String element = driver.findElement(By.linkText(name)).getText();
		return element;
	}
	
	public void clickByLinkText (String name){
		driver.findElement(By.linkText(name)).click();
	}
	
	public int getNumberOfCssLocators (String css){
		return driver.findElements(By.cssSelector(css)).size();
		
	}
	
	public int getNumberOfXPathLocators (String xpath){
		return driver.findElements(By.xpath(xpath)).size();
		
	}
	
	public String getTextByCss (String css){
		String text = driver.findElement(By.cssSelector(css)).getText();
		return text;
	}
	
	public void getURL (String additionalURL){
		driver.get(baseUrl + additionalURL);
	}
	
	public void getWholeURL (String URL){
		driver.get(URL);
	}
	
	public void clickById (String id){
		driver.findElement(By.id(id)).click();
	}
	
	public void clickByCss (String css){
		driver.findElement(By.cssSelector(css)).click();
	}
	
	public void clearById(String id){
		driver.findElement(By.id(id)).clear();
	}

	public void sendKeyById (String id, String key){
		driver.findElement(By.id(id)).sendKeys(key);
	}
	
	public String findStringById (String id){
		String element = driver.findElement(By.id(id)).getText();
		return element;
	}
	
	public boolean isElementSelectedById(String id){
		boolean state = driver.findElement(By.id(id)).isSelected();
		return state;
	}
	
	public boolean isElementDisplayedById(String id){
		boolean state = driver.findElement(By.id(id)).isDisplayed();
		return state;
	}
	
	public boolean isElementDisplayedByCss(String css){
		boolean state = driver.findElement(By.cssSelector(css)).isDisplayed();
		return state;
	}
	
	private boolean isElementPresent(WebDriver driver, By by){
		  try{
		   driver.findElement(by);
		   return true;
		  }catch(NoSuchElementException e){
		   return false;
		  }
		 }
	
	public void switchToNextWindow (){
		for (String handle : driver.getWindowHandles()) { 
			driver.switchTo().window(handle); }
	}
	
	public void switchToMainWindow(){
		driver.switchTo().window("");
	}
	
	public void waitForElementById(String id){
		WebElement	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void waitForElementByCss(String css){
		WebElement	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
		}
	
	public void waitForElementLoop(String id ) throws Exception{	
		for (int second = 0;; second++) {
			   if (second >= 60) fail("timeout");
			   try { if (isElementPresent(driver,By.id(id))) break;
			   Thread.sleep(1000);
			    } catch (Exception e) {}
		}
	}

	public String getTitle () {
		String title = driver.getTitle();
	return title;
	}
	
	public String generateNumberIntoString(int number){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(number);
		String result = Integer.toString(randomInt);
		return result;
	}
	
	public float convertStringToFloat(String string){
		Float floatValue = new Float(string);
		return floatValue;
	}
	
	public void sleep(long inverval) throws InterruptedException{
		Thread.sleep(inverval);
	}
	public void tearDown() {
		driver.quit();
	}
	
	
}	