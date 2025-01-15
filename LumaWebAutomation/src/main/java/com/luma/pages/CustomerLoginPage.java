package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ReportUtils;

public class CustomerLoginPage extends CommonPgae{

	public CustomerLoginPage(WebDriver driver) {
		super(driver);

	}

	private By email1 =By.id("email");
	private By password1 =By.id("pass");
	private By signInButton = By.xpath("(//span[text()='Sign In'])[1]");


	public void signInWithEmailAndPassword(String email, String password) {

		driver.findElement(email1).sendKeys(email);
		ReportUtils.log.info("Enterted email: " + email);

		driver.findElement(password1).sendKeys(password);
		ReportUtils.log.info("Enterted password: " + "**********");

		driver.findElement(signInButton).click();
		ReportUtils.log.info("Clicked sign in button");

	}
}
