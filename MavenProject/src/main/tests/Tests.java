import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.AWTException;

@Test
public class Tests {
	
	/*
	 * Class Objects
	 */
	Driver driver;
	WebDriver webDriver;
	UserInput user;
	String contents;
	Displayer display;
	
	@BeforeTest
	public void beforeTest() {
		driver = new Driver();
		user    = new UserInput();  										// new user object
		display = new Displayer();											// new display object
		
		user.getOriginalLang();												// prompt user for source language
		
		user.getTranslatingLang();											// prompt user to enter language to translate into
		user.getMessageToTranslate();										// prompt user for message to translate

		webDriver = driver.getDriver("Chrome");											// start chrome driver
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	

	public void translateLanguage() throws AWTException, InterruptedException {
		
		driver.getTranslatePage("https://translate.google.com/");
		
		// Set source language on google translate page
		driver.classNameClick("sl-more"); 									// clicks more language drop down icon
		driver.idNameClick   ("sl_list-search-box"); 						// clicks search box
		driver.idNameSendKey ("sl_list-search-box", user.getInput()); 		// enters source language in search box
		driver.enterKeyId    ("sl_list-search-box");						// hit enter key 
		driver.timeOut       (2);											// wait 2 seconds

		// Set translation language
		driver.classNameClick("tl-more");									// clicks more language drop down icon							
		driver.idNameClick   ("tl_list-search-box");						// clicks search box
		driver.idNameSendKey ("tl_list-search-box", user.getTranslated());	// enters translation language in search box
		driver.enterKeyId    ("tl_list-search-box");						// hit enter key
		driver.timeOut       (2);											// wait 2 seconds
		
		// Set message that user wants translated
		driver.idNameClick   ("source");									// Clicks on source box to input message
		driver.idNameSendKey ("source", user.getMessage());					// enters message user wants to translate
		driver.timeOut       (2);											// wait 2 seconds
		
		contents = driver.getAttribute("tlid-translation");					// sets contents from translated id

		//contents = webDriver.findElement(By.className("tlid-translation")).getText();
		
		
		display.printTranslation(contents);									// displays translation to user
	}
}
