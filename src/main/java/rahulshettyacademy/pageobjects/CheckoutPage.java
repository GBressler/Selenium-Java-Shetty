package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	//@FindBy(xpath = "//button[contains(@class, 'ta-item')])[2]")
	//@FindBy(xpath = "//section/button")
	@FindBy(xpath = "//button[contains(@class, 'ta-item') and normalize-space(.)='%s')]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//button[contains(@class, 'ta-item') and contains(., 'Argentina')]")
    private WebElement argentina;
	
	//@FindBy(xpath = "//button[contains(@class, 'ta-item') and .//i[contains(@class, 'fa-search')] and contains(., '%s')]")
    //private WebElement countryButtonXPath;

	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		//waitForElementToAppear(By.cssSelector(".ta-results"));
		argentina.click();
		
		//Actions b = new Actions(driver);
		//b.sendKeys(country, Keys.TAB).build().perform();
		
		//country.sendKeys(Keys.TAB);
		
		//waitForElementToAppear(By.xpath("//button[contains(@class, 'ta-item') and .//i[contains(@class, 'fa-search')] and normalize-space(.)='%s')]"));
		//selectCountry.click();
		//selectCountry.sendKeys(Keys.ENTER);
		
		//String dynamicXPath = String.format("//button[contains(@class, 'ta-item') and .//i[contains(@class, 'fa-search')] and normalize-space(.)='%s')]", countryName);
        //WebElement dynamicCountryButton = driver.findElement(By.xpath(dynamicXPath));
        //dynamicCountryButton.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
	
}
