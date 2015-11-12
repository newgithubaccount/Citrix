package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumWrapper;

public class WebinarLogin {
	
	public WebDriver driver=null;
	SeleniumWrapper wrapper=null;
	@FindBy(how=How.XPATH,using="//input[@id='emailAddress']")
	WebElement userName;
	@FindBy(how=How.ID,using="password")
	WebElement password;
	@FindBy(how=How.XPATH,using="//input[@id='submit']")
	WebElement login;
	
	
	public WebinarLogin(String browser)
	{
		/*System.setProperty("webdriver.chrome.driver","C:/Users/swapna_kota/workspace/SmithaCitrixWebinar/lib/chromedriver.exe");
		driver= new ChromeDriver();
		*/
		wrapper=new SeleniumWrapper(browser);
	//	wrapper.load("https://login.citrixonline.com/login?");
		wrapper.load("https://global.gotowebinar.com/webinars.tmpl");
		driver=wrapper.getDriver();
		//driver.get("https://global.gotowebinar.com/webinars.tmpl");
		PageFactory.initElements(driver, this);
		wrapper.maximiseBrowser();
	}
	
	public MyWebinarSelection login(String userName1,String Password1)
	{
		wrapper.type(userName, userName1, "entering user name");
		wrapper.type(password, Password1, "entering password");
		wrapper.click(login, "clicking on login button");
		return new MyWebinarSelection(wrapper);
	}
	
	

}
