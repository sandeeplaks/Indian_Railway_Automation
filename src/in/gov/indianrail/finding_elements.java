package in.gov.indianrail;

import in.gov.indianrail.PageObjects.inside_heading_text;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class finding_elements {
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
		//inside_heading_text.getSourceStationDropdown(driver).sendKeys("CHENNAI - MAS");
		driver.findElement(By.name("lccp_src_stncode")).sendKeys("CHENNAI - MAS");
		driver.findElement(By.name("lccp_dstn_stncode")).sendKeys("TRIVANDRUM - TVC");
		driver.findElement(By.name("lccp_day")).clear();

		driver.findElement(By.name("lccp_day")).sendKeys("4");
		driver.findElement(By.name("lccp_month")).clear();

		driver.findElement(By.name("lccp_month")).sendKeys("11");
		List <WebElement> buttons = driver.findElements(By.name("monitor"));
		buttons.get(1).click();
		driver.findElement(By.name("lccp_ret_day")).clear();
		driver.findElement(By.name("lccp_ret_day")).sendKeys("6");
		driver.findElement(By.name("lccp_ret_month")).sendKeys("11");
		driver.findElement(By.name("lccp_classopt")).sendKeys("ALL CLASS");
		driver.findElement(By.className("btn_style")).click();
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(Exception ignore){
			
		}
		
		
		
		
		//Choose the train we want 
		/*List <WebElement> trains = driver.findElements(By.name("lccp_trndtl"));
		trains.get(3).click();
		driver.findElement(By.name("lccp_submitpath")).click();
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(Exception ignore){
			
		}*/
		
		
		//Re-writing the above using the for loop.
		//Identifying by class to isolate table. Go to first table and findElements by rows.
		//Go to third row and figure out the td's
		
		
		List <WebElement> train_tables = driver.findElements(By.className("table_border_both_left"));
		WebElement train_table = train_tables.get(0);
		List <WebElement> table_rows = train_table.findElements(By.tagName("tr"));
		int counter = 0;
		for(WebElement table_row : table_rows){
			counter = counter +1;
			if(counter < 3)
				continue;
			List<WebElement> table_data = table_row.findElements(By.tagName("td"));
			WebElement myFirstTd = table_data.get(0);
			if(myFirstTd.getText().contentEquals("22207")) {
				Assert.assertEquals("Validating text at TD(0)", "22207", myFirstTd.getText());
				myFirstTd.click();
				System.out.println(myFirstTd.getText() + "is present");
				break;
			}else
				System.out.println("Your train is not present");
			
		}
		
		//Validating presence of element using train name and not train no
		List <WebElement> train_routes = driver.findElements(By.className("table_border_both_left"));
		WebElement our_route = train_routes.get(0);
		List <WebElement> route_rows = our_route.findElements(By.tagName("tr"));
		int count = 0;
		for(WebElement route_row : route_rows)
		{
			count  = count + 1;
			if (count < 3)
				continue;
			List <WebElement> route_data = route_row.findElements(By.tagName("td"));
			WebElement my_first_route_data = route_data.get(1);
			if(my_first_route_data.getText().contentEquals("+SUPER AC EXP"))
			{
				Assert.assertEquals("Validating train name", "+SUPER AC EXP".toUpperCase(), my_first_route_data.getText().toUpperCase());
			    System.out.println(my_first_route_data.getText() + "is present");
			    break;
			}else
			    	System.out.println(my_first_route_data.getText() + "is not your train");
			
			}
		
		//Validating presence of headers which gives information about trains.
		List <WebElement> train_detail_headers = driver.findElements(By.className("table_border_both_left"));
		WebElement my_table_detail = train_detail_headers.get(0);
		List <WebElement> my_table_row = my_table_detail.findElements(By.tagName("tr"));
		int counting = 0;
		for(WebElement my_rows : my_table_row)
		{
			if(!(counting < 1)) break;
				counting = counting + 1;	
				List <WebElement> my_table_row_data = my_rows.findElements(By.tagName("td"));
					int i=0;
					WebElement heading;
					heading = my_table_row_data.get(i);
			      
			    	Thread.sleep(3000);   
					Assert.assertEquals("Validating train no", "Train No.", heading.getText());
			    	System.out.println(heading.getText() + "is_present");
			       
			       i++;
			       
			       
			       heading = my_table_row_data.get(i);
			       
			    	   Assert.assertEquals("Validating train name", "Train Name", heading.getText());
			    	   System.out.println(heading.getText() + "is_present");
			      
			       i++;
			       
			       heading = my_table_row_data.get(i);
			       
			    	   Assert.assertEquals("Validating train origin", "Origin", heading.getText());
			    	   System.out.println(heading.getText() + "is_present");
			     
			       i++;
			       
			       heading = my_table_row_data.get(i);
			       
			    	   Assert.assertEquals("Validating Departure time", "Dep.Time", heading.getText());
			    	   System.out.println(heading.getText() + "is present");
			       
			       i++;
			       heading = my_table_row_data.get(i);
			       
			    	   Assert.assertEquals("Validating Destination", "Destination", heading.getText());
			    	   System.out.println(heading.getText() + "is present");
			       
			       i++;
			       
			       heading = my_table_row_data.get(i);
			       
			       
			       
			       
			
		
		}
		
		
		
		
		
		
		
				
				
				
				
		
		
		//driver.get("http://www.indianrail.gov.in/cgi_bin/inet_trnnum_cgi.cgi");no longer required if navigating from a different page
		/*List <WebElement> tables = driver.findElements(By.tagName("table"));
		WebElement our_table = tables.get(3);
		List <WebElement> our_data = our_table.findElements(By.tagName("td"));
		WebElement our_interested_data = our_data.get(1);
		WebElement our_stuff = our_interested_data.findElement(By.tagName("font"));
		Assert.assertEquals("Validating Table heading", "INDIAN RAILWAYS PASSENGER RESERVATION ENQUIRY".toUpperCase(), our_stuff.getText().toUpperCase());
		System.out.println(our_stuff.getText() + "is found");*/
		
		
		
		
		// Locating and finding the links which are present
		
		//WebElement links = our_data.get(2);
	/*	List <WebElement> mylinks = links.findElements(By.tagName("a"));
		for (WebElement link:mylinks)
		{
			if(!link.isDisplayed()) Assert.assertFalse("Links are not displayed", true);
			else
				System.out.println(link.getText() + "is present");
		}
		}
			
		//driver.findElement(By.name("lccp_src_stncode")).sendKeys("CHENNAI - MAS");
		// Locating text "Train ROute" Which is nested several depth more
		//Using the table and finding elements by rows
		 /*WebElement row_text = tables.get(8);
		 List <WebElement> row_interested = row_text.findElements(By.tagName("td"));
		 WebElement data_interested = row_interested.get(0);*/
		
		/*WebElement text_route = driver.findElement(By.className("inside_heading_text"));
		 Assert.assertEquals("TRAIN ROUTE".toUpperCase(), text_route.getText().toUpperCase());*/
		 
		
		
		
		
		
		}
	
	
	@After
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}

}
