package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("***Starting TC001_AccountRegistrationTest***");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked On My Account Link");
			hp.clickRegister();
			logger.info("Clicked On Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			/*
			 * regpage.setFirstName("Mubarak"); regpage.setLastName("Chand");
			 * regpage.setEmail("mubarakchand@gmail.com");
			 * regpage.setTelephone("1234567890");
			 */

			// String password = randomAlphanumeric();
			logger.info("Providing Customer Details");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setTelephone(randomeNumber());

			String password = randomeAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating Expected Message");
			String confmsg = regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		} catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("***Finished TC001_AccountRegistrationTest***");
	}

}
