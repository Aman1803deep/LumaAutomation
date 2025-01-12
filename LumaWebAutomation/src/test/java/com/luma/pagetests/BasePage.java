package com.luma.pagetests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import utils.BaseUtils;

public class BasePage {

	WebDriver driver;

	@BeforeTest
	public void Start() throws NumberFormatException, IOException {

		String browser = BaseUtils.getConfigValue("browser");
		//cross browser testing
		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("invalid browser");
			break;

		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(BaseUtils.getConfigValue("implicitwait"))));
		driver.navigate().to(BaseUtils.getConfigValue("url"));
	}

	@AfterMethod
	public void Ending() {

		driver.quit(); //close browser

	}
}
