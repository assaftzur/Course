package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseDriver;
import pages.HomePage;


public class HomePageTests extends BaseDriver {

	@BeforeMethod
	public void beforeMethod() {
	startSession();
	PageFactory.initElements(driver, HomePage.class);
	}

	@Test (priority=3, groups="Sanity,Regression")
	public void firstStep() {
		HomePage.UserMessage.sendKeys("Assaf");
		HomePage.ShowMessageButton.click();
//		String text = HomePage.DisplayMessage.getText();
//		System.out.println(text);
		//Assert.assertTrue(text.equals("Assaf"));
//		Assert.assertEquals(text, "ASsaf");
		Assert.assertEquals(HomePage.DisplayMessage.getText(), "ASsaf");
	}

	@AfterMethod
	public void afterMethod() {
		closeSession();
	}

}
