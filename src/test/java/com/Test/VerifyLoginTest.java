package com.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.LoginPom;
import com.Utility.BaseClass;
import com.Utility.Library;

public class VerifyLoginTest extends BaseClass{
	
	@Test
	
	public void verify_tc_01_loginwithvalidcredentials() {
		
		LoginPom login=PageFactory.initElements(driver, LoginPom.class);
		
		Library.custom_sendkeys(login.gettext_emailid(), exel.getstringdata("Sheet1", 0, 0), "email");
		Library.custom_sendkeys(login.gettext_pass(), exel.getstringdata("Sheet1", 0, 1), "password");
		Library.custom_click(login.getbutton_lohin(), "login");
		//Assert.assertTrue(false);
	}
	

}
