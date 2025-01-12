package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends CommonPgae{

	public CustomerLoginPage(WebDriver driver) {
		super(driver);

	}

	private By email =By.id("email");
	private By password =By.id("pass");
	private By signInButton =By.xpath("//button[@type='Submitt']");

	public void inputEmailPassword() {
		driver.findElement(email).sendKeys("Aman1243kaur@gmail.com");
		driver.findElement(password).sendKeys("Abc1234");
		driver.findElement(signInButton).click();
	}
}
