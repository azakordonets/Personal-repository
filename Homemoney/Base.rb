require "rubygems"
require "selenium-webdriver"
require "test/unit"


module Base
class Utils < Test::Unit::TestCase

  def initialize
    @driver = Selenium::WebDriver.for :firefox
  end

   #list of locators variables
  @base_url =   "http://dev.homemoney.com.ua/"
  @logout_button_locator = "ctl00_ctl00_Top_LV2_LoginStatus2"
  @sign_in_button_locator = "login-nav-signin"
  @login_edit_field_locator = "ctl00_Main_rl1_hmLogin_login"
  @password_edit_field_locator = "ctl00_Main_rl1_hmLogin_password"
  @login_button_locator = "ctl00_Main_rl1_hmLogin_LoginButton"
  @total_sum_edit_field_locator = "ctl00_ctl00_Main_Main_opEdit_txtTotal"
  @description_edit_field_locator = "ctl00_ctl00_Main_Main_opEdit_txtDescription"
  @date_button_locator = "ctl00_ctl00_Main_Main_opEdit_ImgTransBtnCalendar"
  @calendar_day_icon_locator = "ctl00_ctl00_Main_Main_opEdit_ce1_day_0_2"
  @calendar_edit_field_locator = "ctl00_ctl00_Main_Main_opEdit_txtDate"
  @account_drop_down_locator = "ctl00_ctl00_Main_Main_opEdit_ddlAccount"
  @category_drop_down_locator = "ctl00_ctl00_Main_Main_opEdit_ddlCategoriesExp"
  @currency_drop_down_locator = "ctl00_ctl00_Main_Main_opEdit_ddlCurrency"


def self.idClick (id)
    @driver.find_element(:id, id).click
end

  def self.idSelectByText (id,text)
      @driver.find_element(:id, id).select_by(:text, text)

def self.linkClick (link)
    @driver.find_element(:link, link).click
end

def self.cssClick (css)
   @driver.find_element(:css, css).click
end

def self.xpathClick (xpath)
   @driver.find_element(:xpath, xpath).click
end

def self.goTo (url_add)
    @driver.get(@base_url +"#{url_add}")
end

def self.getTitle (title)
  @driver.getTitle
  (title)
end

def self.clear (element_id)
   @driver.find_element(:id, element_id).clear
end

def self.sendKeys (element_id,key_to_send)
    @driver.find_element(:id, element_id).send_keys key_to_send
end

def self.logout ()
    @driver.find_element(:id, @logout_button_locator).click
end


  def enter_sum(sum)
     Utils.clear(@total_sum_edit_field_locator)
     Utils.sendKeys(@total_sum_edit_field_locator, sum )
  end

  def enter_description_to_operation(comment)
     Utils.clear(@description_edit_field_locator)
     Utils.sendKeys(@description_edit_field_locator,comment)
  end

  def set_date(date)
     Utils.idClick(@date_button_locator)
     Utils.idClick(@calendar_day_icon_locator)
     Utils.clear(@calendar_edit_field_locator)
     Utils.sendKeys(@calendar_edit_field_locator,date)
  end

def select_account(account_name)
  #Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, )).select_by(:text, account_name)
  Selenium::WebDriver::Support::Select.new(Utils.idSelectByText(@account_drop_down_locator,account_name))
end

  def select_category(category_name)
    @driver = Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, @category_drop_down_locator)).select_by(:text,category_name)
  end

  def select_currency (currency)
    @driver = Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, @currency_drop_down_locator)).select_by(:text, currency)
  end


  def teardown
    @driver.quit
    assert_equal [], @verification_errors
end

end
end

end

