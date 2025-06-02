package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		//Java class that pulls from GlobalData.properties file
		Properties prop = new Properties();
		//convert GlobalData file to stream
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		//load the stream via the properties
		prop.load(fis);
		
		//specify the property to load from the properties file.
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//Firefox
//			System.setProperty("webdriver.firefox.driver", "Path/to/Firefox/driver");
//			driver = new FirefoxDriver();
		} 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
}
