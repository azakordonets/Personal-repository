package com.jayway.test;

import com.mobclix.android.demo.*;
import com.jayway.android.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.ImageView;


public class MoblixDemoTestG extends ActivityInstrumentationTestCase2<MobclixDemo>{

	private Solo solo;

	public MoblixDemoTestG() {
		super("com.moblix.android.demo", MobclixDemo.class);

	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testCanOpenSettings() throws InterruptedException{
        
    		//solo.wait(5000);
		
            for(ImageView image : solo.getCurrentImageViews()) 
            { 
                    int name_width =   image.getWidth();
                    int name_height = image.getHeight();
                    System.out.print(name_width);
                    System.out.print(name_height);
                
            } 

   }
	
	@Smoke
	public void testAdvertising() throws Exception {
		
		solo.clickOnButton("Advertising");
		
		testCanOpenSettings(); 
		
		solo.goBack();

	}
	
	@Smoke
	public void testRefreshAds() throws Exception {
		
		solo.clickOnButton("Advertising");
		
		/*
		testCanOpenSettings();
		 */
		solo.clickOnButton("RefreshAds");
		
		testCanOpenSettings(); 
		
		solo.goBack(); 
	}


	@Smoke
	public void testGetFSAd() throws Exception {
		
		solo.clickOnButton("Advertising");
		solo.clickOnButton("Get FullScreen Ad");
		
		solo.goBack(); 

	}

	@Smoke 
	public void testDisplayFSAd() throws Exception {
		
		solo.clickOnButton("Advertising");

		solo.clickOnButton("Get FullScreen Ad");
		
		solo.clickOnButton("Display FullScreen Ad");

		testCanOpenSettings();
		
		solo.goBack(); 

	}


	@Smoke
	public void testGetAndDisplayFSAd() throws Exception {
		
		solo.clickOnButton("Advertising");
		
		solo.clickOnButton("Get and Display FullScreen Ad");
		
		testCanOpenSettings(); 
		
		solo.goBack(); 

	}
	

	@Override
	public void tearDown() throws Exception {
		//Robotium will finish all the activities that have been opened
		solo.finishOpenedActivities();
	}
}
