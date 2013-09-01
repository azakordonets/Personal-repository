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
   select_account(@account)
   enter_sum(@sum)
   select_currency(@currency)
   select_category(@category )
   enter_description_to_operation(@comment)
   set_date(@date)
  end

end