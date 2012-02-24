require "rubygems"
require "selenium-webdriver"
require "test/unit"
require "Base"
require "Home Page"
require "Control Panel"



a = Login.new("testhome","homemoney")
a.login
b = Operations.new("New Account","1000","UAH","Жилье","hello","2/1/2012")
b.add_operation