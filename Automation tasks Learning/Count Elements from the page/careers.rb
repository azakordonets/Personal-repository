require "selenium-webdriver"
require "rspec"
include RSpec::Expectations

describe "Careers" do

  before(:each) do
    @driver = Selenium::WebDriver.for :firefox
    @driver.manage.timeouts.implicit_wait = 30
    @verification_errors = []
  end
  
  after(:each) do
    @driver.quit
    @verification_errors.should == []
  end
  
  it "test_careers" do
    @driver.get "/"
    @driver.find_element(:css, "li.careers > a > span").click
    @driver.find_element(:xpath, "//div[2]/div/div/ul/li[2]/a/span").click
  end
  
  def element_present?(how, what)
    @driver.find_element(how, what)
    true
  rescue Selenium::WebDriver::Error::NoSuchElementError
    false
  end
  
  def verify(&blk)
    yield
  rescue ExpectationNotMetError => ex
    @verification_errors << ex
  end
end
