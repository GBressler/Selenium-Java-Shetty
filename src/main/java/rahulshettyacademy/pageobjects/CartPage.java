package rahulshettyacademy.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartProducts.stream().anyMatch(cartProduct-> 
//		cartProduct.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
		public Boolean VerifyProductDisplay(String productName) {
			Boolean match = productTitles.stream().anyMatch(product-> 
			product.getText().equalsIgnoreCase(productName));
			return match;
		}
		
		
	
		public CheckoutPage goToCheckout() {
			checkoutEle.click();
			return new CheckoutPage(driver);
		}
		
}
