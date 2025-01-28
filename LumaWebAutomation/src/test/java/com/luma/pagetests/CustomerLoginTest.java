package com.luma.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.pages.CreateNewCustomerAccountPage;
import com.luma.pages.CustomerLoginPage;
import com.luma.pages.MyAccountPage;
import utils.RandomDataGenerator;
import utils.ReportUtils;
public class CustomerLoginTest extends BaseTest {

	
	  @Test
	    public void verifySuccessfulCreationOfNewCustomerAccountTest() {
	        // Step 1: Navigate to the account creation page
	        CreateNewCustomerAccountPage createAccountPage = new CreateNewCustomerAccountPage(driver);
	        createAccountPage.clickCreateAnAccountLink();
	        
	        
	        // Step 2: Generate random user data
	        String firstName = RandomDataGenerator.generateRandomFirstName();
	        String lastName = RandomDataGenerator.generateRandomLastName();
	        String email = RandomDataGenerator.generateRandomEmail();
	        String password = RandomDataGenerator.generateRandomPassword();
             System.out.println("test");
	        createAccountPage.FillCreateForm(firstName, lastName, email, password);
	 
	    
     // Verify account creation confirmation
	        verifyAccountCreation();

	        //Sign out of the account
	        signOutOfAccount();

	        //Log in with new account
	        logInWithAccount(email, password);

	        //Verify successful login
	        verifyLoginSuccess();
	    }

	  

	    private void verifyAccountCreation() {
	        MyAccountPage myAccountPage = new MyAccountPage(driver);

	        // Assert confirmation message for account creation
	        Assert.assertEquals(myAccountPage.getConfirmationMessage(), "Thank you for registering with Main Website Store.");
	        ReportUtils.log.pass("Test passed: Account creation confirmation message is displayed.");

	        // Optionally, we could validate page title and heading if needed
	        // Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
	        // Assert.assertEquals(myAccountPage.getPageHeader(), "My Account");
	    }

	    private void signOutOfAccount() {
	        MyAccountPage myAccountPage = new MyAccountPage(driver);

	        // Click on user header button and sign out
	        myAccountPage.clickUserHeaderBtn();
	        myAccountPage.clickSignOut();

	        // Assert sign-out message
	        Assert.assertEquals(myAccountPage.getPageHeader(), "You are signed out");
	        ReportUtils.log.pass("Test passed: Sign out was successful.");
	    }

	    private void logInWithAccount(String email, String password) {
	        // Navigate to the login page and sign in
	        CustomerLoginPage loginPage = new CustomerLoginPage(driver);
	        loginPage.clickSignInLink();
	        loginPage.signInWithEmailAndPassword(email, password);
	    }

	    private void verifyLoginSuccess() {
	        // Assert the page title to ensure the login was successful
	        CustomerLoginPage loginPage = new CustomerLoginPage(driver);
	        Assert.assertEquals(loginPage.getPageTitle(), "My Account");
	        ReportUtils.log.pass("Test passed: Login was successful.");
	    }
}