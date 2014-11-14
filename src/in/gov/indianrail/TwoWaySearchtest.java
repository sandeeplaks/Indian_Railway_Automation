package in.gov.indianrail;

import java.util.List;

import junit.framework.Assert;
import in.gov.indianrail.PageObjects.inside_heading_text;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TwoWaySearchtest {
	
	private WebDriver driver;
	
	@Before
	public void beforeTest()
	{
		driver = new FirefoxDriver();
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get("http://www.indianrail.gov.in/between_Imp_Stations.html");
		inside_heading_text.getSourceStationDropdown(driver).sendKeys("CHENNAI - MAS");
		inside_heading_text.getDestinationStationDropdown(driver).sendKeys("TRIVANDRUM - TVC");
		inside_heading_text.getTravelDate(driver).clear();
		inside_heading_text.getTravelDate(driver).sendKeys("4");
		inside_heading_text.getTravelMonth(driver).clear();
		inside_heading_text.getTravelMonth(driver).sendKeys("11");
		inside_heading_text.getSeatClass(driver).sendKeys("ALL CLASS");
		inside_heading_text.clickRadioButton(driver).get(1).click();
		inside_heading_text.getReturnDate(driver).clear();
		inside_heading_text.getReturnDate(driver).sendKeys("6");
		inside_heading_text.getReturnMonth(driver).clear();
		inside_heading_text.getReturnMonth(driver).sendKeys("11");
		inside_heading_text.clickSubmitButton(driver).click();
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(Exception ignore){
		}
		
		
		//choosing the train we want
		inside_heading_text.chooseTrain(driver).get(3).click();
		inside_heading_text.submitClicking(driver).click();
		
		
		//Asserting text
		inside_heading_text.choosingTables(driver).get(3).click();
		inside_heading_text.choosingTableData(driver).get(1);
		inside_heading_text.getData(driver);
		Assert.assertEquals("Validating table heading", "INDIAN RAILWAYS PASSENGER RESERVATION ENQUIRY".toUpperCase(),inside_heading_text.getHeader(driver).getText().toUpperCase());
		System.out.println(inside_heading_text.getHeader(driver).getText() + "is present");
		
		
		//Locating and finding the links which are present
		
		List<WebElement> myLists = inside_heading_text.getLinks(driver);
		
		for(WebElement myList : myLists){
			{
				if(!myList.isDisplayed())  Assert.assertFalse("Link is not displayed", true);
				else
					System.out.println(myList.getText() + "is present");
			}
		}
		
		
}
	
	
	@After
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}

}
