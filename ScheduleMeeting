package pageobjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumWrapper;
import mx4j.util.Utils;

public class ScheduleMeeting {
	
	//RandomStringUtils.randomAlphanumeric(20).toUpperCase();
	public WebDriver driver=null;
	SeleniumWrapper wrapper=null;
	@FindBy(how=How.XPATH,using="//input[@id='name']")
	WebElement webinarTitle;
	@FindBy(how=How.XPATH,using="//textarea[@id='description']")
	WebElement description;
	@FindBy(how=How.XPATH,using="//input[@value='Schedule']")
	WebElement Schedule;
	@FindBy(how=How.XPATH,using="//input[@id='webinarTimesForm.dateTimes_0.baseDate']")
	WebElement weibinarDate;
	@FindBy(how=How.XPATH,using="//img[@class='ui-datepicker-trigger']")
	WebElement weibinarDateSelection;
	@FindBy(how=How.XPATH,using="//img[@title='Choose a date']")
	WebElement chooseDate;
	@FindBy(how=How.XPATH,using="//input[@id='webinarTimesForm.dateTimes_0.startTime']")
	WebElement startTime;
	@FindBy(how=How.XPATH,using="//a[@id='webinarTimesForm_dateTimes_0_startAmPm_trig']/span[@class='label ellipsis']/span")
	WebElement startTimeZone;
	@FindBy(how=How.XPATH,using="//input[@id='webinarTimesForm.dateTimes_0.endTime']")
	WebElement endTime;
	@FindBy(how=How.XPATH,using="//a[@id='webinarTimesForm_dateTimes_0_endAmPm_trig']/span[@class='label ellipsis']/span")
	WebElement endTimeZone;	
	
	public  static String webinartile=RandomStringUtils.random(15, "abcdefghijklmnopqrstuvwxyz");
	public static String webinardescription=RandomStringUtils.random(15, "abcdefghijklmnopqrstuvwxyz");
	public ScheduleMeeting(SeleniumWrapper wrapper)
	{	this.wrapper=wrapper;
		driver=wrapper.getDriver();
		PageFactory.initElements(driver, this);
	}
	public MyWebinarSelection schedule()
	{
		wrapper.type(webinarTitle,webinartile, "entering scheduler title");
		
		wrapper.type(description, webinardescription, "entering description");
		
		wrapper.click(Schedule, "clicking on schedule button");
		return new MyWebinarSelection(wrapper);
	}
	
	public void selectWebinarDate(int date,boolean  value)
	{
		wrapper.click(weibinarDateSelection, "selecting date icon selector");
		String baseXpath=null;
		String fullXpath=null;
		WebElement month=wrapper.findWebElement("//span[@class='ui-datepicker-month']");
		if(date<=7&&date>=1)		
		{
			baseXpath="//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[";
			switch(date)
			{
			case 1: fullXpath=baseXpath+"1]/a";
					break;
			case 2: fullXpath=baseXpath+"2]/a";
			break;
			case 3: fullXpath=baseXpath+"3]/a";
			break;
			case 4: fullXpath=baseXpath+"4]/a";
			break;
			case 5: fullXpath=baseXpath+"5]/a";
			break;
			case 6: fullXpath=baseXpath+"6]/a";
			break;
			case 7: fullXpath=baseXpath+"7]/a";
			break;
			}
		}
		else if(date<=14&&date>=8)
		{
			baseXpath="//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[";
			switch(date)
			{
			case 8: fullXpath=baseXpath+"1]/a";
					break;
			case 9: fullXpath=baseXpath+"2]/a";
			break;
			case 10: fullXpath=baseXpath+"3]/a";
			break;
			case 11: fullXpath=baseXpath+"4]/a";
			break;
			case 12: fullXpath=baseXpath+"5]/a";
			break;
			case 13: fullXpath=baseXpath+"6]/a";
			break;
			case 14: fullXpath=baseXpath+"7]/a";
			break;
			}
		}
		else if(date<=21&&date>=15)
		{
			baseXpath="//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[";
			switch(date)
			{
			case 15: fullXpath=baseXpath+"1]/a";
					break;
			case 16: fullXpath=baseXpath+"2]/a";
			break;
			case 17: fullXpath=baseXpath+"3]/a";
			break;
			case 18: fullXpath=baseXpath+"4]/a";
			break;
			case 19: fullXpath=baseXpath+"5]/a";
			break;
			case 20: fullXpath=baseXpath+"6]/a";
			break;
			case 21: fullXpath=baseXpath+"7]/a";
			break;
			}
		}
		else if(date<=28&&date>=22)
		{
			baseXpath="//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[";
			switch(date)
			{
			case 22: fullXpath=baseXpath+"1]/a";
					break;
			case 23: fullXpath=baseXpath+"2]/a";
			break;
			case 24: fullXpath=baseXpath+"3]/a";
			break;
			case 25: fullXpath=baseXpath+"4]/a";
			break;
			case 26: fullXpath=baseXpath+"5]/a";
			break;
			case 27: fullXpath=baseXpath+"6]/a";
			break;
			case 28: fullXpath=baseXpath+"7]/a";
			break;
			}
		}
		else if(date<=29&&date>=31)
		{
			baseXpath="//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[";
			switch(date)
			{
			case 29: fullXpath=baseXpath+"1]/a";
					break;
			case 30: fullXpath=baseXpath+"2]/a";
			break;
			case 31: fullXpath=baseXpath+"3]/a";
			break;
			
			}
		}
		if(value)
		wrapper.click(wrapper.findWebElement("//span[text()='Next']"), "moving to next month");
		WebElement dateFiled=wrapper.findWebElement(fullXpath);
		wrapper.click(dateFiled, "clicking on the date");
		  
	
	}
	public String getWebbinarDate()
	{
		return wrapper.getText(weibinarDate);
	}
	public String getWebbinarTitle()
	{
		return wrapper.getText(webinarTitle);
	}
	public String getWebbinarDescription()
	{
		return wrapper.getText(description);
	}
	public String getStartTime()
	{
		return wrapper.getText(startTime);
	}
	public String getStartDateTimeZone()
	{
		return wrapper.getText(startTimeZone);
	}
	public String getEndDate()
	{
		return wrapper.getText(endTime);
	}
	public String getEndDateTimeZone()
	{
		return wrapper.getText(endTimeZone);
	}
	
	
}
