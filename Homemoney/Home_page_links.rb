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
  def enter_credentials
    Utils.goTo("/#")
    Utils.idClick("login-nav-signin")
    Utils.clear("ctl00_Main_rl1_hmLogin_login")
    Utils.sendKeys("ctl00_Main_rl1_hmLogin_login",@name)
    Utils.clear("ctl00_Main_rl1_hmLogin_password")
    Utils.sendKeys("ctl00_Main_rl1_hmLogin_password",@password)
    Utils.idClick("ctl00_Main_rl1_hmLogin_LoginButton")
    Utils.logout
  end

end

a = Login.new("testhome","homemoney")
a.enter_credentials