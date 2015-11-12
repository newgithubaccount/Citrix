package Utilities;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SeleniumWrapper {
	//will be useful to carry actions on to a browser
	public static WebDriver driver;
	//Can be helped to manage wait conditions for all webElements
	public static WebDriverWait wait;
	//Can be used to invoke the browser according to the user Request
	public String browser;
	//Used Log4j Logger and can be used in order to log the actions performed
	
	//Method which helps you to invoke chrome browser by default in order to drive the tests
	public SeleniumWrapper(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 90);
		//instantiating logger object for logging mechanism
		

	}	
	public WebDriver getDriver()
	{
		return driver;
	}
	//Method which invokes the browser basing on the browser given by the user from the testcase
public SeleniumWrapper(String currentBrowser){		
		this.browser = currentBrowser.trim();
		//launches firefox browser with the created profile
		if (browser.contentEquals("firefox")) {
				File profileDir = new File("C://Users//admin//AppData//Roaming//Mozilla//Firefox//Profiles//nm3u0iby.OPS/");
				System.setProperty("webdriver.firefox.profile",profileDir.toString());
				FirefoxProfile firefoxProfile = new FirefoxProfile(profileDir);
				firefoxProfile.setAcceptUntrustedCertificates (true); 
				driver = new FirefoxDriver(firefoxProfile);
			
		}else if(browser.contentEquals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//launches InternetExplorer browser with some capabilities
		else if (browser.contentEquals("internetexplorer"))
		{	
			System.setProperty("webdriver.ie.driver","./lib/IEDriverServer1.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();     
	          caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	          caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "Ignore");
	           caps.setCapability("ignoreZoomSetting", true);
	           caps.setCapability("nativeEvents", false);
	           driver = new InternetExplorerDriver(caps);
	           
		}
		
		wait = new WebDriverWait(driver, 10);
		
	}

/* Frequently used selenium methods will be written in the wrapper 
 * so that the selenium code will be seperated completed from the end test class java code
 */

	public String getTitle() {
	return driver.getTitle();
}
	public void LoadPage(String urlToOpen) {
		driver.get(urlToOpen);		
	}
	//method overloading for implementing all 3 types of select statements
	public void select(WebElement element,String elementValue) {
		driver.switchTo().activeElement();
		Select select = new Select(element);
		try {
			select.selectByValue(elementValue);
		} catch (NoSuchElementException notFoundEx) {
			
		}
	}
	public void select(WebElement element,String visibleText,String type) {
		driver.switchTo().activeElement();
		Select select = new Select(element);
		try {
			select.selectByVisibleText(visibleText);
		} catch (NoSuchElementException notFoundEx) {
			
		}
	}
	public void select(WebElement element,String Comments,int index) {
		driver.switchTo().activeElement();
		Select select = new Select(element);
		try {
			select.selectByIndex(index);
		} catch (NoSuchElementException notFoundEx) {
			
		}
	}
	//method which helps to wait for element
	public void waitForElement(By locator) throws TimeoutException{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void type(WebElement element, String value, String description){
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
		
	}
	public void click(WebElement element, String toBeLogged) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	public void load(String url)
	{
		driver.get(url);
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public void maximiseBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public WebElement findWebElement(String xpath)
	{
		return driver.findElement(By.xpath(xpath));
		
	}
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
