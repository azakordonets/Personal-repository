require "rubygems"
require "selenium-webdriver"
require "test/unit"


module Base
class Utils < Test::Unit::TestCase

  def initialize (driver, base_url)
  @driver = driver
  @base_url = base_url
end

def setup
    @driver = Selenium::WebDriver.for :firefox
    @base_url = "http://dev.homemoney.com.ua/"
  end

def self.idClick (id)
    @driver.find_element(:id, id).click
end

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
    @driver = Selenium::WebDriver.for :firefox
    @base_url = "http://dev.homemoney.com.ua/"
    @driver.get(@base_url)
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
    @driver.find_element(:id, "ctl00_ctl00_Top_LV2_LoginStatus2").click
end



def teardown
    @driver.quit
    assert_equal [], @verification_errors
end

end

end

#@driver.find_element(:id, "login-nav-signin").click
#    @driver.find_element(:id, "ctl00_Main_rl1_hmLogin_login").clear
#    @driver.find_element(:id, "ctl00_Main_rl1_hmLogin_login").send_keys "hometest"
#    @driver.find_element(:id, "ctl00_Main_rl1_hmLogin_password").clear
#    @driver.find_element(:id, "ctl00_Main_rl1_hmLogin_password").send_keys "homemoney"
#    @driver.find_element(:id, "ctl00_Main_rl1_hmLogin_LoginButton").click
#    @driver.find_element(:id, "login-nav-signin").click
#
#
#
#
#    @driver.find_element(:id, "feature-nav-tab-2").click
#    @driver.find_element(:id, "feature-nav-tab-3").click
#    @driver.find_element(:id, "login-nav-signin").click
#    @driver.find_element(:id, "ctl00_LoginView1_A2").click
#    @driver.find_element(:id, "ctl00_LoginView1_A1").click
#    @driver.find_element(:link, "Тур по сайту").click
#    @driver.find_element(:link, "мобильную версию сайта").click
#    @driver.find_element(:link, "приложением для iPhone").click
#    @driver.find_element(:link, "или Android").click
#    @driver.find_element(:id, "show-more-reviews").click
#    @driver.find_element(:css, "ul.footer-nav > li > a").click
#    @driver.find_element(:link, "Статьи").click
#    @driver.find_element(:link, "Форум").click
#    @driver.find_element(:link, "Мобильная версия").click
#    @driver.find_element(:link, "Приложение для iPhone").click
#    @driver.find_element(:link, "Приложение для Android").click
#    @driver.find_element(:link, "О проекте").click
#    @driver.find_element(:link, "Отзывы").click
#    @driver.find_element(:link, "Сообщить об ошибке").click
#    @driver.find_element(:link, "Twitter").click
#    @driver.find_element(:link, "Facebook").click
#    @driver.find_element(:link, "В Контакте").click
#    @driver.find_element(:id, "ctl00_ctl00_Top_LV2_LoginStatus2").click
