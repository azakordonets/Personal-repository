require "rubygems"
require "selenium-webdriver"
require "test/unit"

class CarrersTestUnit < Test::Unit::TestCase

  def setup
    @driver = Selenium::WebDriver.for :firefox
    @driver.manage.timeouts.implicit_wait = 30
    @verification_errors = []
  end
  
  def teardown
    @driver.quit
    assert_equal [], @verification_errors
  end
  
  def test_carrers_test_unit
    @driver.get "http://cogniance.com"
    @driver.find_element(:css, "li.careers > a > span").click
    @driver.find_element(:xpath, "//div[2]/div/div/ul/li[2]/a/span").click
    puts number_of_positions = @driver.find_elements(:css, ".one_career h3")[0].text
    puts "Number of elements on the page is #{number_of_positions.to_s}."
    count = 1
    while count<=number_of_positions
      puts  name = 'Name of the position is ' + @driver.find_element(:xpath, "//div[2]/div/div[2]/div/div[2]/div[#{count.to_s}]/h3").text.to_s+'.'
      count +=1
    end

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
