package in.gov.indianrail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	//@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://jqueryui.com/slider/");
		Thread.sleep(10000);
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement slider = driver.findElement(By.id("slider")).findElement(By.tagName("span"));
		
		Actions actions = new Actions(driver);
		Action moveSlider = actions.dragAndDropBy(slider, 50, 0).build();
		moveSlider.perform();
	}

}
