package org.cogniance.helloworld.test;

//import junit.framework.TestCase;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

@SuppressWarnings("unchecked")
public class TestDemo extends ActivityInstrumentationTestCase2 {

        private static final String TARGET_PACKAGE_ID = "com.mobclix.android.demo";
        private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mobclix.android.demo.MobclixDemo";

        private static Class<?> launcherActivityClass;
        static{
                try {
                        launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
                } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }
        
        @SuppressWarnings("unchecked")
        public TestDemo() throws ClassNotFoundException {
                super(TARGET_PACKAGE_ID, launcherActivityClass);
        }
        
        private Solo solo;
        
        @Override
        protected void setUp() throws Exception {
                solo = new Solo(getInstrumentation(), getActivity());
        }

        public void testCanOpenSettings() throws InterruptedException{
                
        	solo.pressMenuItem(0);
				solo.wait(5000);
			
                for(ImageView image : solo.getCurrentImageViews()) 
                { 
                        int name_width =   image.getWidth();
                        int name_height = image.getHeight();
                        System.out.print(name_width);
                        System.out.print(name_height);
                    
                        //assertTrue(name.equals("sign_in_with_aim_or_aol")); 
                } 

       }


 @Override
   public void tearDown() throws Exception {
                solo.finishOpenedActivities();

  }


}

