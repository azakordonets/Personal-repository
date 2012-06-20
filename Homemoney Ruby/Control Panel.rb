require "rubygems"
require "selenium-webdriver"
require "test/unit"
require "Base"


class Operations < Base::Utils
  attr_accessor :sum, :currency, :comment, :account, :category, :date
  def initialize(account,sum,currency,category,comment,date)
    @sum = sum
    @currency = currency
    @comment = comment
    @account = account
    @category = category
    @date = date
  end
  def add_operation
   #@driver =  Selenium::WebDriver::Support::Select.new(@driver.find_element(:id, "ctl00_ctl00_Main_Main_opEdit_ddlAccount")).select_by(:text, "Наличные деньги")
   select_account(@account)
   enter_sum(@sum)
   select_currency(@currency)
   select_category(@category )
   enter_description_to_operation(@comment)
   set_date(@date)
  end

end