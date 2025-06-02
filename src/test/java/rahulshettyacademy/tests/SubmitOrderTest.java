package rahulshettyacademy.tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import rahulshettyacademy.pageobjects.AbstractComponent;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;

public class SubmitOrderTest {
	
	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
		//pages
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("juandoe@fakemail.com", "C0ntrasena");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Argentina");
		//Thread.sleep(5000);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String confirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-controller")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		//WebElement country = driver.findElement(By.tagName("input[placeholder='Select Country']"));
		//country.sendKeys("arg");
		//driver.findElement(By.cssSelector(".ta-item")).click();
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		//another option
	
		
	}
}
