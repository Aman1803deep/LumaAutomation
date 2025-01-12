package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CreateNewCustomerAccountPage{

	WebDriver driver;

	public CreateNewCustomerAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element locators
	private By createAccountLink =By.xpath("(//span[text()='Create an Account'])[1]");
	private By FirstName=By.xpath("//input[@name='firstname']");
	private By LastName =By.xpath("//input[@name='lastname']");
	private By Email=By.xpath("//input[@id='email_address']");
	private By password=  By.xpath("//input[@id='password']");
	private By confirmPassword= By.xpath("//input[@id='password-confirmation']");
	private By createAnAccountButton =By.xpath("//button[@title='Create an Account']");

	 // Method to fill out the "Create Account" form and submit
	public void SendAllValues() {
		driver.findElement(createAccountLink).click();
		driver.findElement(FirstName).sendKeys("Amandeep");
		driver.findElement(LastName).sendKeys("Kaur");
		driver.findElement(Email).sendKeys("Amankaur@gmail.com");
		driver.findElement(password).sendKeys("Abc@1234");
		driver.findElement(confirmPassword).sendKeys("Abc@1234");
		driver.findElement(createAnAccountButton).click();

	}
	
	 // Method to click the Sign In link
	private By signInLink = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
	public void clickSignInLink() {

		driver.findElement(signInLink).click();

	}






}
