require "rubygems"
require "selenium-webdriver"
require "test/unit"

class Untitled < Test::Unit::TestCase

  def setup
    @driver = Selenium::WebDriver.for :firefox
    @base_url = "http://dev.homemoney.com.ua/"
    @driver.manage.timeouts.implicit_wait = 30
    @verification_errors = []
  end
  
  def teardown
    @driver.quit
    assert_equal [], @verification_errors
  end
  
  def test_untitled
    @driver.get(@base_url + "/beta/")
    Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ddlAccount")).select_by(:text, "Наличные деньги")
    Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ddlCurrency")).select_by(:text, "UAH")
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtTotal").clear
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtTotal").send_keys "1000"
    Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ddlCategoriesExp")).select_by(:text, "Жилье")
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtDescription").clear
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtDescription").send_keys "hello"
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ImgTransBtnCalendar").click
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ce1_day_0_2").click
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtDate").clear
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_txtDate").send_keys "2/1/2012"
    @driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_btnAdd").click
  end
  
  def element_present?(how, what)
    @driver.find_element(how, what)
    true
  rescue Selenium::WebDriver::Error::NoSuchElementError
    false
  end
  
  def verify(&blk)
    yield
  rescue Test::Unit::AssertionFailedError => ex
    @verification_errors << ex
  end
end
