package testcases2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.Factory.BaseClass;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.extra.pages.homepage;
import com.wp.staging.admin.pages.GPwdPage;
import com.wp.staging.admin.pages.GSigninPage;
import com.wp.staging.admin.pages.WPMerchantSearch;
import com.wp.staging.admin.pages.loginpage;

public class TC02_SigninviaGmail  extends BaseClass{

	loginpage login ;
	GSigninPage Signin ;
	GPwdPage gpwd ;
	WPMerchantSearch adminpage;
	@Test(dataProvider = "Credentials", dataProviderClass=CustomDataProvider.class)
	public void  SigninPage(String username, String password)
	{
		//creating objects of pages needed
		login = new loginpage(driver);
		Signin = new GSigninPage(driver);
		gpwd = new GPwdPage(driver);
		adminpage = new WPMerchantSearch(driver);
		
		//Click on Login button
		Assert.assertTrue(driver.getTitle().contains("Login"));
		
		//Click on GoogleLogin button
		login.googleSignin();
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
	
		//Enter Username and Password
		 Signin.gSign(username);
	    Boolean status = gpwd.pwdPageValidate();
	    Assert.assertTrue(status);
		gpwd.gPwd(password);
      	Boolean statuslogo = adminpage.wishpondLogo();
		Assert.assertTrue(statuslogo);
		
		
        
        
		
	  }
	
}
