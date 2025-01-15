package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.ReportUtils;

public class CommonPgae extends BasePage {

	public CommonPgae(WebDriver driver) {
		super(driver);
	}

	private By userHeaderBtn = By.xpath("(//button[@type='button'])[1]");
	private By signOutLink = By.xpath("(//a[contains(string(),'Sign Out')])[1]");

	private By createAnAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
	private By signInLink = By.xpath("(//a[contains(text(), 'Sign In')])[1]");

	// Locators for Women navigation, Top option and hoodies & Sweatshirts
	private By womenNavigationOption = By.xpath("//a[@role='menuitem']//span[text()='Women']");
	private By selectTop = By.xpath("//a[@role='menuitem']//span[text()='Tops']");
	private By selecthoodiesSweatshirtsOption = By.xpath("//a[@role='menuitem']//span[text()='Hoodies & Sweatshirts']");

	public void clickCreateAnAccountLink() {

		driver.findElement(createAnAccountLink).click();
		ReportUtils.log.info("Clicked on Create An Account Link");

	}

	public void clickSignInLink() {

		driver.findElement(signInLink).click();

	}

	public void clickUserHeaderBtn() {

		driver.findElement(userHeaderBtn).click();

	}

	public void clickSignOut() {

		driver.findElement(signOutLink).click();

	}

	public void NavigateToHoodiesSweatshirts() {

		WebElement WomenNavigationOption = driver.findElement(womenNavigationOption);
		WebElement selectTopsOption = driver.findElement(selectTop);
		WebElement selecthoodiesSweatshirtsEle = driver.findElement(selecthoodiesSweatshirtsOption);

		Actions action = new Actions(driver);

		// Hover over the "Women" menu item, then hover over the "Tops" option, and
		// click on "Hoodies & Sweatshirts"
		action.moveToElement(WomenNavigationOption).moveToElement(selectTopsOption).click(selecthoodiesSweatshirtsEle)
				.perform();
		
		// Log the action performed
		ReportUtils.log.info("Hovered over Women, then hovered to tops and select Hoodies & Sweatshirts");

	}
}
