import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	WebDriver driver;
	
	/*
	 * Constructor class for driver
	 */
	public Driver() 
	{
		driver = null;
	}
	
	/*
	 * Driver for getting browser type and chrome driver 
	 */
	public WebDriver getDriver(String browserType) {
		
		if (browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/ChromeDriver/v77/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	/*
	 * Set the google translated page
	 */
	public void getTranslatePage(String url) {
		driver.get(url);
		//return driver;
	}
	
	/*
	 * For clicking on an element by class name
	 */
	public void classNameClick(String classN) {
		driver.findElement(By.className(classN)).click();
		//return driver;
	}
	
	/*
	 * for clicking on an element by id name
	 */
	public WebDriver idNameClick(String idName) {
		driver.findElement(By.id(idName)).click();
		return driver;
	}
	
	/*
	 * for sending keys to id element
	 */
	public WebDriver idNameSendKey(String idName, String input) {
		driver.findElement(By.id(idName)).sendKeys(input);
		return driver;
	}
	
	/*
	 * for sending ENTER key to id element
	 */
	public WebDriver enterKeyId(String idName) {
		driver.findElement(By.id(idName)).sendKeys(Keys.ENTER);
		return driver;
	}
	
	/*
	 * to have page wait a certain length of time that is passed in
	 */
	public WebDriver timeOut(int length) {
		driver.manage().timeouts().implicitlyWait(length, TimeUnit.SECONDS);
		return driver;
	}

	/*
	 * Get inner text by class name if attribute is inntertext
	 */
	public String getAttribute(String id) {
		String attribute = driver.findElement(By.className(id)).getAttribute("innerText");
		return attribute;
	}

	/*
	 * Quit Chrome driver
	 */
	public void quit() {
		driver.quit();
	}
	
}
