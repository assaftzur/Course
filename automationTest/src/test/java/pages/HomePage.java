package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	@FindBy(id = "user-message")
	// (xpath="//input[@type='text' and @id='user-message']")
	public static WebElement UserMessage;

	@FindBy(xpath = "//*[@id=\"get-input\"]/button")
	// (xpath=//button[contains(text(),'Show Message')]
	public static WebElement ShowMessageButton;

	@FindBy(id = "display")
	public static WebElement DisplayMessage;

}
