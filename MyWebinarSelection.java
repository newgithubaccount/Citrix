package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.SeleniumWrapper;

public class MyWebinarSelection {
	
	public WebDriver driver=null;
	SeleniumWrapper wrapper=null;
	@FindBy(how=How.XPATH,using="//a[@id='scheduleWebinar']/div/span")
	WebElement scheduleWebinar;
	@FindBy(how=How.XPATH,using="//a[text()='My Webinars']")
	WebElement myWebinars;
	@FindBy(how=How.XPATH,using="//div[@id='upcomingWebinar']/div/div[1]/ul[@class='myWebinarMain']/li[2]/span")
	WebElement webinarDate;
	@FindBy(how=How.XPATH,using="//div[@id='upcomingWebinar']/div/div[1]/ul[@class='myWebinarDetail']/div/li[2]/span")
	WebElement webinarTime;
	@FindBy(how=How.XPATH,using="//div[@id='upcomingWebinar']/div/div[1]/ul[@class='myWebinarMain']/li[3]/a/span")
	WebElement webinarTitle;
	
	
	
	public MyWebinarSelection(SeleniumWrapper wrapper)
	{	this.wrapper=wrapper;
		driver=wrapper.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public ScheduleMeeting clickschedulemeeting()
	{
		wrapper.implicitWait();
		wrapper.click(scheduleWebinar, "clicked on schedule a webinar");
		System.out.println("")
		return new ScheduleMeeting(wrapper);
	}
	public void clickSchudledwebinars()
	{
		wrapper.click(myWebinars, "clicking on my webinars");
	}
	
	public String getWebinarTime()
	{
		return wrapper.getText(webinarTime);
	}
	public String getWebinarTitle()
	{
		return wrapper.getText(webinarTitle);
	}
	public String getWebinarDate()
	{
		return wrapper.getText(webinarDate);
	}
	
	public void webinarDetails(int date,String title)
	{
		int local=1;
		String baseXpath=null;
		for(int i=1;i<=50;++i)
		{
			if(i>1)
			{
				
			 baseXpath="//div[@id='upcomingWebinar']/div/div["+(local+6)+"]";
			local=local+6;
			
			}
			else if(i==1)
				 baseXpath="//div[@id='upcomingWebinar']/div/div["+i+"]";
			String webinarDateXpath=baseXpath+"/ul[@class='myWebinarMain']/li[2]/span";
			String webinarTime=baseXpath+"/ul[@class='myWebinarDetail']/div/li[2]/span";
			String webinarTitle=baseXpath+"/ul[@class='myWebinarMain']/li[3]/a/span";
			WebElement webinarTitleElement=wrapper.findWebElement(webinarTitle);
			WebElement webinarTimeElement=wrapper.findWebElement(webinarTime);
			WebElement webinarDateElement=wrapper.findWebElement(webinarDateXpath);
			if(wrapper.getText(webinarTitleElement).equals(title))
			{
				Assert.assertTrue(true);
				if(wrapper.getText(webinarDateElement).contains(Integer.toString(date)))
					Assert.assertTrue(true);
				break;
			}			
			
		}
		
		
	}
	public void closeBrowser()
	{
		wrapper.closeBrowser();
	}
}
