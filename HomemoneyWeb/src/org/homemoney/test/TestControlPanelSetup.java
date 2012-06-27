package org.homemoney.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
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

public class TestControlPanelSetup {
	ControlPanel cp = new ControlPanel ();
	ControlPanelSetup cps = new ControlPanelSetup ();
	@Before
	public void initialize(){
		cp.setUp();
		cp.MainLogin("testhome", "homemoney");	
	}
	
	
	@Test
	public void checkShowOnDashboardOption() throws InterruptedException{
		cp.clickControlPanelSetupLink();
		cps.clickDisplayOnDashboardCheckBox("New account", true);
	}
		
	
	
	
	@After
	public void finilize(){
		cp.tearDown();
	}



}
