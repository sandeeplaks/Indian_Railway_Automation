package in.gov.indianrail.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inside_heading_text {
	public static WebElement getSourceStationDropdown(WebDriver driver){
		return driver.findElement(By.name("lccp_src_stncode"));
	}
	public static WebElement getDestinationStationDropdown(WebDriver driver){
		return driver.findElement(By.name("lccp_dstn_stncode"));
	}
	public static WebElement getTravelDate(WebDriver driver) {
		return driver.findElement(By.name("lccp_day"));
	}
	
	public static WebElement getTravelMonth(WebDriver driver)
	{
		return driver.findElement(By.name("lccp_month"));
	}
	
	public static List<WebElement> clickRadioButton(WebDriver driver)
	{
		return driver.findElements(By.name("monitor"));
	}
	
	public static WebElement getReturnDate(WebDriver driver)
	{
		return driver.findElement(By.name("lccp_ret_day"));
	}
	
	public static WebElement getReturnMonth (WebDriver driver)
	{
		return driver.findElement(By.name("lccp_ret_month"));
	}
	
	
	public static WebElement getSeatClass(WebDriver driver)
	{
		return driver.findElement(By.name("lccp_classopt"));
	}
	
	public static WebElement clickSubmitButton(WebDriver driver)
	{
		return driver.findElement(By.className("btn_style"));
	}
	
	// Page 2. Page objects for choosing the trains we want.
	
	public static List <WebElement> chooseTrain(WebDriver driver)
	{
		return driver.findElements(By.name("lccp_trndtl"));
	}
	
	
	public static WebElement submitClicking(WebDriver driver)
	{
		return driver.findElement(By.name("lccp_submitpath"));
	}
	
	// Page Objects required for asserting text
	public static List <WebElement> choosingTables(WebDriver driver)
	{
		return driver.findElements(By.tagName("table"));
	}
	
	public static List <WebElement> choosingTableData(WebDriver driver)
	{
		return driver.findElements(By.tagName("td"));
	}
	
	public static WebElement getData(WebDriver driver)
	{
		return driver.findElement(By.tagName("font"));
	}
	public static WebElement getHeader(WebDriver driver){
		List <WebElement> tables = driver.findElements(By.tagName("table"));
		WebElement our_table = tables.get(3);
		List <WebElement> our_data = our_table.findElements(By.tagName("td"));
		WebElement our_interested_data = our_data.get(1);
		return our_interested_data.findElement(By.tagName("font"));
	}
	//Page -objects method.
	/*private static final By byTable = By.tagName("table");
	private static final By byTagName = By.tagName("td");*/
	
	// Page objectsLocating and finding the links which are present
	public static List<WebElement> getLinks(WebDriver driver)
	{
		List <WebElement> tables = driver.findElements(By.tagName("table"));
		WebElement our_table = tables.get(3);
		List <WebElement> our_data = our_table.findElements(By.tagName("td"));
		WebElement links =  our_data.get(2);
		return links.findElements(By.tagName("a"));
	}
	
}
