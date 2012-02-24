require "rubygems"
require "selenium-webdriver"
require "test/unit"
require "General_action"

class Login
  include Base
  attr_accessor :name, :password
  def initialize(name,password)
    @name = name
    @password = password
  end
  def login
    Utils.goTo("/#")
    Utils.click_sign_in_button
    Utils.enter_login(@name)
    Utils.enter_password(@password)
    Utils.click_login_button
    #Utils.logout
  end

end


class Operations
  include Base
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
   Utils.select_account(@account)
   Utils.enter_sum(@sum)
   Utils.select_currency(@currency)
   Utils.select_category(@category )
   Utils.enter_description_to_operation(@comment)
   Utils.set_date(@date)
  end

end

a = Login.new("testhome","homemoney")
a.login
b = Operations.new("New Account","1000","UAH","Жилье","hello","2/1/2012")
b.add_operation