package com.luma.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ReportUtils;

public class HoodiesShirtsPage extends CommonPgae {

	public HoodiesShirtsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators for list view and grid view of the product display.
	By listView = By.xpath("(//div[@class='modes']//a[@title='List'])[1]");
	By gridView = By.xpath("(//div[@class='modes']//a[@title='Grid'])[1]");

	By sortByOption = By.id("sorter");
	By productNameLinks = By.xpath("(//strong[contains(@class,'product name')]/a)[1]");

	public void verifySortingInView(HoodiesShirtsPage page, boolean isListView) {
		if (isListView) {
			page.clickListView(); // Switch to List View
		} else {
			page.clickGridView(); // Switch to Grid View
		}
	}

	public void clickListView() {
		driver.findElement(listView).click();
		ReportUtils.log.info("Clicked List View");
	}

	public void clickGridView() {
		driver.findElement(gridView).click();
		ReportUtils.log.info("Clicked Grid View");

	}

	public void sortByProductName() {
		WebElement sortByEle = driver.findElement(sortByOption);

		Select select = new Select(sortByEle);
		select.selectByContainsVisibleText("Product Name");

		ReportUtils.log.info("Sorted Products by Product name");

	}

	public boolean verifyProductNamesAreSorted() {
		// Retrieve all product name elements from the webpage
		List<WebElement> productNamesEle = driver.findElements(productNameLinks);

		// Create a list to store the product names
		ArrayList<String> productNamesArrayList = new ArrayList<>();
		for (WebElement productNameEle : productNamesEle) {
			// Extract the text from each WebElement (product name) and add to the list
			productNamesArrayList.add(productNameEle.getText());
		}

		// Create a copy of the original list and sort it
		ArrayList<String> sortedProductNamesArrayList = new ArrayList<>(productNamesArrayList);
		Collections.sort(sortedProductNamesArrayList);

		// Compare the original list with the sorted list
		return productNamesArrayList.equals(sortedProductNamesArrayList);
	}
}
