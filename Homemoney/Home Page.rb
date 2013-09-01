require "rubygems"
require "selenium-webdriver"
require "test/unit"
require "Base"

class Login < Base::Utils
  attr_accessor :name, :password
  def initialize(name,password)
    super()
    @name = name
    @password = password
  end
    @sign_in_button_locator = "login-nav-signin"
    @login_edit_field_locator = "ctl00_Main_rl1_hmLogin_login"
    @password_edit_field_locator = "ctl00_Main_rl1_hmLogin_password"
    @login_button_locator = "ctl00_Main_rl1_hmLogin_LoginButton"

  def click_sign_in_button
      idClick(@sign_in_button_locator)
  end

  def enter_login(login)
      clear(@login_edit_field_locator)
      sendKeys(@login_edit_field_locator,login)
  end

  def enter_password(password)
      clear(@password_edit_field_locator)
      sendKeys(@password_edit_field_locator,password)
  end

  def click_login_button
      idClick(@login_button_locator)
  end

  def login
      goTo("/#")
      click_sign_in_button
      enter_login(@name)
      enter_password(@password)
      click_login_button
      #logout
  end

end




