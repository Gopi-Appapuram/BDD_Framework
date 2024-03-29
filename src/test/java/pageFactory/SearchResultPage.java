package pageFactory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utility.ScreenshotUtility;
import Utility.ScrollUtility;
import Utility.SeleniumHighlighterUtility;

public class SearchResultPage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;
	ScreenshotUtility screenshot;
	ScrollUtility scroll;

//	@FindBys(@FindBy(xpath = "(//div[contains(@class,'product-detail-container')])")) //(//ul[@class='results-base']//li)
//	List<WebElement> productList;

	@FindBys(@FindBy(xpath = "(//ul[@class='results-base']//li[@class='product-base'])"))
	List<WebElement> productList;

	@FindBys(@FindBy(xpath = "(//label[@class='common-customCheckbox vertical-filters-label']/input[@class='price-input'])"))
	List<WebElement> priceCheckbox;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.scroll = new ScrollUtility(driver);
		this.highlighter = new SeleniumHighlighterUtility(driver);
	}

	public boolean isProdListDisplayed() {
		int prodlist = productList.size();
		try {
			System.out.println("Elements:" + prodlist + ".");
			return prodlist > 0;
		} catch (NullPointerException e) {
			System.out.println("Product list element is null.");
			return false;
		}
	}

	public void clickOnAnyItem() throws Exception {
		int maxProducts = productList.size();
		Random random = new Random();
		int randomProduct = random.nextInt(maxProducts);
		// Click on the product
		scroll.scrollElementIntoView(productList.get(randomProduct));
		productList.get(randomProduct).click();
		Thread.sleep(5000);
	}

	public String searchPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	int maxPriceFilters;
	int ramdomPriceFilter;

	public void selectPriceRange() {
		Random random = new Random();
		maxPriceFilters = priceCheckbox.size();
		System.out.println("filters are " + maxPriceFilters);
		ramdomPriceFilter = random.nextInt(maxPriceFilters);
		scroll.scrollElementIntoView(priceCheckbox.get(ramdomPriceFilter));
		
		try {
			priceCheckbox.get(ramdomPriceFilter).click();
			Thread.sleep(5000);
			} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void FiltersChecked() throws Exception {
		if (priceCheckbox.get(ramdomPriceFilter).isSelected()) {
			scroll.scrollElementIntoView(priceCheckbox.get(ramdomPriceFilter));
			System.out.println("Products are displayed within the range"
					+ priceCheckbox.get(ramdomPriceFilter).getText() + "price range");
			Thread.sleep(5000);
		} else {
			scroll.scrollElementIntoView(priceCheckbox.get(ramdomPriceFilter));
			System.out.println("Price filters are not applied.");
		}
		;
	}

}
