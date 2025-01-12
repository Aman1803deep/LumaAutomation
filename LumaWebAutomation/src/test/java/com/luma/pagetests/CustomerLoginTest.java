package com.luma.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.pages.CreateNewCustomerAccountPage;
import com.luma.pages.CustomerLoginPage;
import com.luma.pages.MyAccountPage;




public class CustomerLoginTest extends BasePage {

	@Test
	public void verifySuccessfulCreationOfNewCustomerAccountTest() throws InterruptedException {

		// click on Create An Account link
		CreateNewCustomerAccountPage createAccountPage = new CreateNewCustomerAccountPage(driver);
		createAccountPage.clickSignInLink();


		// fill &  submit the 'Create An Account' form
		createAccountPage.SendAllValues();

		// verify Account registration message,  title and heading
		MyAccountPage myAccountpage = new MyAccountPage(driver);
		Assert.assertEquals(myAccountpage.getConfirmationMessage(),
				"Thank you for registering with Main Website Store.");
		Assert.assertEquals(myAccountpage.getPageTitle(), "My Account");
		Assert.assertEquals(myAccountpage.getPageHeader(), "My Account");

		// sign out from My Account
		myAccountpage.clickUserHeaderBtn();
		myAccountpage.clickSignOut();

		// verify sign out message
		Assert.assertEquals(myAccountpage.getPageHeader(), "You are signed out");
		Thread.sleep(5000);

		// click on Sign In
		CustomerLoginPage loginPage = new CustomerLoginPage(driver);
		loginPage.clickSignInLink();

		// Sign in again
		loginPage.inputEmailPassword();

		// verify page title, heading after login
		Assert.assertEquals(loginPage.getPageTitle(), "Home Page");

}
}