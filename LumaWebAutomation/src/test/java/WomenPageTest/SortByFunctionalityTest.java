package WomenPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.pages.HoodiesShirtsPage;

import com.luma.pagetests.BaseTest;

import utils.ReportUtils;

public class SortByFunctionalityTest extends BaseTest {

	@Test
	public void verifySortByFunctionality() {

		// Create an instance of the 'Hoodies & Sweatshirts' page
		HoodiesShirtsPage hoodiesSweatshirtsPage = new HoodiesShirtsPage(driver);

		// Navigate to the 'Hoodies & Sweatshirts' page
		hoodiesSweatshirtsPage.NavigateToHoodiesSweatshirts();

		// Validate the page title to ensure the correct page is loaded
		Assert.assertEquals(hoodiesSweatshirtsPage.getPageTitle(), "Hoodies & Sweatshirts - Tops - Women");

		// logs the page loads successfully
		ReportUtils.log.pass("Verified that the category landing page loads successfully");

		// Verify sorting functionality in List View
		verifySortingInView(hoodiesSweatshirtsPage, true);

		// Verify sorting functionality in Grid View
		verifySortingInView(hoodiesSweatshirtsPage, false);
	}

	// Helper method to verify sorting in both List and Grid views
	private void verifySortingInView(HoodiesShirtsPage page, boolean isListView) {
		if (isListView) {
			page.clickListView(); // Switch to List View
		} else {
			page.clickGridView(); // Switch to Grid View
		}

		// Sort products by product name
		page.sortByProductName();
		

        // Assert that product names are sorted alphabetically
        Assert.assertTrue(page.verifyProductNamesAreSorted(), "Product names are not sorted alphabetically in the view.");
        String viewType = isListView ? "List" : "Grid";  // Determine which view we are testing
        ReportUtils.log.pass("Test passed: Products are displayed in ascending alphabetical order by 'Product Name' in " + viewType + " View.");
    }

		

	}

