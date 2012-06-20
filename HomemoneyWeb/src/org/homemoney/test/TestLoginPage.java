package org.homemoney.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.bcel.verifier.statics.IntList;
import org.homemoney.objects.*;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLoginPage {
		
		LoginPage login = new LoginPage ();
	
		@Test @Ignore
		public void TopLogin() throws Exception {
			login.setUp();
			login.TopLogin("testhome", "homemoney");
			String loginName = login.findStringById("ctl00_ctl00_Top_LV2_LoginName1");
			System.out.println(loginName);
			assertEquals("testhome",loginName );
			login.tearDown();
			
		}
				
		@Test @Ignore
		public void MainLogin() throws Exception {
			login.setUp();
			login.MainLogin("testhome", "homemoney");
			String loginName = login.findStringById("ctl00_ctl00_Top_LV2_LoginName1");
			assertEquals( "testhome",loginName);
			login.tearDown();			
		}
		
		@Test @Ignore
		public void WrongLogin() throws Exception {
			login.setUp();
			login.MainLogin("testhome2", "homemoney");
			login.waitForElementById("ctl00_Main_rl1_hmLogin_divErrorLogin");
			assertEquals("Пользователь с такой электронной почтой или логином не зарегистрирован.",login.findStringById("ctl00_Main_rl1_hmLogin_divErrorLogin"));
			login.tearDown();
		}
		
		@Test @Ignore
		public void WrongPassword () throws Exception {
			login.setUp();
			login.clickById("login-nav-signin");
			login.clearById("ctl00_Main_rl1_hmLogin_login");
			login.sendKeyById("ctl00_Main_rl1_hmLogin_login", "testhome");
			login.clickById("ctl00_Main_rl1_hmLogin_LoginButton");
			login.waitForElementById("ctl00_Main_rl1_hmLogin_divErrorPassword");
			assertEquals("Проверьте пароль.",login.findStringById("ctl00_Main_rl1_hmLogin_divErrorPassword"));
			login.tearDown();
			
		}
		
		@Test @Ignore
		public void MainSignUp () throws Exception{
			login.setUp();
			Random number = new Random ();
			int random_number = number.nextInt(1000);
			login.SignUp("test"+random_number+"@gmail.com", "password");
			assertEquals("test"+random_number+"@gmail.com",login.getLoginName());
			login.tearDown();
		}
		
		
		@Test @Ignore
		public void TopSignUp () throws Exception {
			login.setUp();
			Random number = new Random ();
			int random_number = number.nextInt(1000);
			login.TopSignUp("test"+random_number+"@gmail.com", "password");
			assertEquals("test"+random_number+"@gmail.com",login.getLoginName());
			login.tearDown();	
		}
		
		
		@Test @Ignore
		public void ReviewLinkTest () throws Exception {
			login.setUp();
			login.GetReviewLink();
			assertEquals("Обзор Homemoney: домашняя бухгалтерия онлайн",login.getTitle());
			login.tearDown();
		}
		
			
		@Test @Ignore
		public void BlogLinkTest () throws Exception {
			login.setUp();
			login.getBlogLink();
			System.out.println(login.getTitle());
			assertEquals("Cтатьи и полезные материалы об экономии расходов, инвестициях, планировании затрат, ведении личного бюджета",login.getTitle());
			login.tearDown();
		}
		
		
		@Test @Ignore
		public void AndroidLinkTest () throws Exception {
			login.setUp();
			login.getAndroidVersionLink();
			assertEquals("Домашняя бухгалтерия онлайн Homemoney - приложение для Android",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void iPhoneLinkTest () throws Exception {
			login.setUp();
			login.getiPhoneVersionLink();
			assertEquals("Домашняя бухгалтерия онлайн Homemoney - приложение для iPhone",login.getTitle());
			login.tearDown();
		}
		
		
		@Test @Ignore
		public void MobileVersionLinkTest () throws Exception {
			login.setUp();
			login.getMobileVersionLink();
			assertEquals("Homemoney[mini]",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void ContactsLinkTest () throws Exception {
			login.setUp();
			login.getContactsLink();
			assertEquals("Контакты",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void FeedbackLinkTest () throws Exception {
			login.setUp();
			login.getFeedbackLink();
			assertEquals("HomeMoney",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void BugReportLinkTest () throws Exception {
			login.setUp();
			login.getBugReportLink();
			assertEquals("Сообщить об ошибке",login.getTitle());
			login.tearDown();
		}
		
		
		@Test @Ignore
		public void TwitterLinkTest () throws Exception {
			login.setUp();
			login.getTwitterLink();
			login.switchToNextWindow();
			login.waitForElementByCss("*[href=\"http://feedback.homemoney.ua\"]");
			System.out.println(login.getTitle());
			assertEquals("homemoneynews (homemoneynews) on Twitter",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void FacebookLinkTest () throws Exception {
			login.setUp();
			login.getFacebookLink();
			login.switchToNextWindow();
			System.out.println(login.getTitle());
			assertEquals("HomeMoney - домашняя бухгалтерия онлайн | Facebook",login.getTitle());
			login.tearDown();
		}
		
		@Test @Ignore
		public void VkontakteLinkTest () throws Exception {
			login.setUp();
			login.getVkontakteLink(); 
			login.switchToNextWindow();
			assertEquals("HomeMoney - домашняя бухгалтерия онлайн",login.getTitle());
			login.tearDown();
		}
		
	}

