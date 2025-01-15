package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ReportUtils;
public class CreateNewCustomerAccountPage{

	WebDriver driver;

	public CreateNewCustomerAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element locators
	
	private By FirstName = By.id("firstname");
	private By LastName =By.id("lastname");
	private By Email=By.id("email_address");
	private By password1 =  By.id("password");
	private By confirmPassword= By.id("password-confirmation");
	private By createAnAccountButton = By.xpath("//button[@title='Create an Account']");
	
	// Method to fill out the "Create Account" form and submit
	public void FillCreateForm(String firstName, String lastName, String email, String password) {

		driver.findElement(FirstName).sendKeys(firstName);
		ReportUtils.log.info("Enterted firstname: " + firstName);

		driver.findElement(LastName).sendKeys(lastName);
		ReportUtils.log.info("Enterted lastName: " + lastName);

		driver.findElement(Email).sendKeys(email);
		ReportUtils.log.info("Enterted email: " + email);

		driver.findElement(password1).sendKeys(password);
		ReportUtils.log.info("Enterted password: " + "*************");

		driver.findElement(confirmPassword).sendKeys(password);
		ReportUtils.log.info(" Entered Confirmed password: " + "*************");

		driver.findElement(createAnAccountButton).click();
		ReportUtils.log.info("Clicked Create An Account Button");

	}
	
	//Method to click the Sign In link
	private By signInLink = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
	public void clickSignInLink() {

		driver.findElement(signInLink).click();

	}
	
	private By createAnAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
	public void clickCreateAnAccountLink() {
		
	
			driver.findElement(createAnAccountLink).click();
			ReportUtils.log.info("Clicked on Create An Account Link");

		}
		
	}







