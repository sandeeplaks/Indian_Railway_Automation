package in.gov.indianrail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class booking_ticket_date_picker {
	private WebDriver driver;
	@Before
	public void setup()
	{
		driver = new FirefoxDriver();
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get("http://www.indianrail.gov.in/between_Imp_Stations.html");
		driver.findElement(By.name("lccp_src_stncode")).sendKeys("CHENNAI - MAS");
		driver.findElement(By.name("lccp_dstn_stncode")).sendKeys("TRIVANDRUM - TVC");
		driver.findElement(By.name("lccp_day")).clear();
		driver.findElement(By.name("lccp_month")).clear();
		WebElement image = driver.findElement(By.cssSelector("#formId > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td.text_back_color > table > tbody > tr > td > table > tbody > tr:nth-child(10) > td:nth-child(2) > img"));
		image.click();
		WebElement month = driver.findElement(By.id("monthSelect"));
		month.click();
		WebElement travel_month = driver.findElement(By.id("monthDiv_11_2014"));
		travel_month.click();
		WebElement my_div = driver.findElement(By.cssSelector("#calendarDiv > div:nth-child(7)"));
		List <WebElement> my_row = my_div.findElements(By.tagName("tr"));
		WebElement myRow = my_row.get(1);
		List <WebElement> my_date = myRow.findElements(By.tagName("td"));
		WebElement date = my_date.get(5);
		date.click();
		driver.findElement(By.name("lccp_classopt")).sendKeys("ALL CLASS");
		
		
		List <WebElement> return_button_radio = driver.findElements(By.name("monitor"));
		WebElement return_buttons = return_button_radio.get(1);
		System.out.println(return_buttons.getText());
		return_buttons.click();
		WebElement return_image = driver.findElement(By.cssSelector("#myGroup > img"));
		return_image.click();
		WebElement month_return = driver.findElement(By.id("monthSelect"));
		month.click();
		WebElement return_travel_month = driver.findElement(By.id("monthDiv_11_2014"));
		return_travel_month.click();
		WebElement my_div_return = driver.findElement(By.cssSelector("#calendarDiv > div:nth-child(7)"));
		List <WebElement> my_row_return = my_div.findElements(By.tagName("tr"));
		WebElement myRowReturn = my_row_return.get(1);
		List <WebElement> my_date_return = myRowReturn.findElements(By.tagName("td"));
		WebElement date_return = my_date_return.get(7);
		date_return.click();
		driver.findElement(By.className("btn_style")).click();


				try{
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}catch(Exception ignore){
					
				}

		
	}
	
	
	
	
	@After
	public void teardown()
	{
		driver.close();
		driver.quit();
	}

}
