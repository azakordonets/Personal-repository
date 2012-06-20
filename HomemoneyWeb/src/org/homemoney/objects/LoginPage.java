package org.homemoney.objects;

public class LoginPage extends Base{
	
	protected void clickEntryTab (){
		clickById("login-nav-signin");
	}
	
	protected void clickSignUpTab (){
		clickById("login-nav-signup");
	}
	
	public void SignUp (String login, String password){
		clickSignUpTab();
		clearById("ctl00_Main_rl1_hmRegistration_txtEmail");
		sendKeyById("ctl00_Main_rl1_hmRegistration_txtEmail", login);
		clearById("ctl00_Main_rl1_hmRegistration_txtTypePassword");
		sendKeyById("ctl00_Main_rl1_hmRegistration_txtTypePassword", password);
		clickById("ctl00_Main_rl1_hmRegistration_btnCreateUser");
		clickById("ctl00_ctl00_Main_Main_firstStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_secondStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_thirdStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_fourthStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_fifthStep_lbSaveAndContinue");
	}
	
	public void TopSignUp (String login, String password) {
		clickById("ctl00_LoginView1_A1");
		clearById("ctl00_Main_Registration_txtEmail");
		sendKeyById("ctl00_Main_Registration_txtEmail", login);
		clearById("ctl00_Main_Registration_txtTypePassword");
		sendKeyById("ctl00_Main_Registration_txtTypePassword", password);
		clickById("ctl00_Main_Registration_btnCreateUser");
		clickById("ctl00_ctl00_Main_Main_firstStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_secondStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_thirdStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_fourthStep_lbSaveAndContinue");
		clickById("ctl00_ctl00_Main_Main_fifthStep_lbSaveAndContinue");
		
	}
	
	public void GetReviewLink (){
		clickByCss(".footer-nav>li>a[href=\"/tour.aspx\"]");
	}
	
	public void getBlogLink (){
		clickByCss(".footer-nav>li>a[href=\"/blog/\"]");
	}
	
	public void getFeedbackLink (){
		clickByCss(".footer-nav>li>a[href=\"http://feedback.dev.homemoney.com.ua\"]");
	}
	
	public void getMobileVersionLink(){
		clickByCss(".footer-nav>li>a[href=\"/m/\"]");
	}
	
	public void getAndroidVersionLink(){
		clickByCss(".footer-nav>li>a[href=\"/Android/\"]");
	}
	
	public void getiPhoneVersionLink(){
		clickByCss(".footer-nav>li>a[href=\"/iPhone/\"]");
	}
	
	public void getContactsLink(){
		clickByCss(".footer-nav>li>a[href=\"/Contact.aspx\"]");
	}
	
	public void getTestimonialsLink(){
		clickByCss(".footer-nav>li>a[href=\"/testimonials.aspx\"]");
	}
	
	public void getBugReportLink(){
		clickByCss(".footer-nav>li>a[href=\"/BugReport.aspx\"]");
	}
	
	public void getTwitterLink(){
		clickByCss(".footer-nav>li>a[href=\"http://twitter.com/homemoneynews\"]");
	}
	
	public void getFacebookLink(){
		clickByCss(".footer-nav>li>a[href=\"http://www.facebook.com/pages/HomeMoney-domasnaa-buhgalteria-onlajn/120547251332066\"]");
	}
	
	public void getVkontakteLink(){
		clickByCss(".footer-nav>li>a[href=\"http://vkontakte.ru/club961724\"]");
	}
	
	
	
	
}