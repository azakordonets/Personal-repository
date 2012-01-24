require "rubygems"
require "selenium-webdriver"
require "test/unit"
require "General_action.rb"

class Home_page_links < Base

  # Called before every test method runs. Can be used
  # to set up fixture information.
  def setup
    @driver = Selenium::WebDriver.for :firefox
    @base_url = "http://dev.homemoney.com.ua/"
    @driver.manage.timeouts.implicit_wait = 30
    @verification_errors = []
  end

  # Called after every test method runs. Can be used to tear
  # down fixture information.

  def test_login
    Base.goTo("/#")
    Base.idClick("login-nav-signin")
    Base.clear("ctl00_Main_rl1_hmLogin_login")
    Base.sendKeys("ctl00_Main_rl1_hmLogin_login","hometest")
    Base.clear("ctl00_Main_rl1_hmLogin_password")
    Base.sendKeys("ctl00_Main_rl1_hmLogin_password","homemoney")
    Base.idClick("ctl00_Main_rl1_hmLogin_LoginButton")

  end

  # Fake test
  def test_fail

    # To change this template use File | Settings | File Templates.
    fail("Not implemented")
  end
end