package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void verify_test() {

		logger.info("***** Starting TC_002_LoginTest *****");

		try {
			// homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// loginpage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// my account
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExist();
			
			
			// Assert.assertEquals(targetPage, true, "Login Failed");
			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finished TC_002_LoginTest *****");

	}

}
