package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPom {

	@FindBy(how=How.XPATH,using="//input[@placeholder='Email address or phone number']")
	private WebElement text_emailid;

	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Password']")
	private WebElement text_pass;
	
	@FindBy(how=How.XPATH,using=("//button[@id='loginbutton']"))
	private WebElement button_login;	
	
	
	public WebElement gettext_emailid() {
		return text_emailid;
		
	}
	
	public WebElement gettext_pass() {
		
		return text_pass;
	}
	
	public WebElement getbutton_login() {
		
		return button_login;
	}
}

