package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utils.PropertyUtil;

public class BaseDriver {
	public WebDriver driver;
	String path = System.getProperty("user.dir");

	public void startSession() {
		try {
			// get browser property from selenium.properties
			PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
			String browser = pus.getProperty("browser");
			String url = pus.getProperty("URL");

			if (browser.equalsIgnoreCase("FireFox")) {
				System.setProperty("webdriver.geckodriver.driver",
						"C:\\Users\\cvnp87\\Downloads\\geckodriver\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\cvnp87\\Downloads\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cvnp87\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

				// ChromeOptions chromeOptions = new ChromeOptions();
				// chromeOptions.addArguments("start-maximized");
				// chromeOptions.addArguments("--disable-gpu");
				// chromeOptions.addArguments("disable-infobars");
				// chromeOptions.addArguments("--disable-extensions");
				// chromeOptions.addArguments("--no-sandbox");
				// chromeOptions.addArguments("--disable-dev-shm-usage");
			}

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void closeSession() {
		driver.quit();

		// driver.manage().deleteAllCookies();
	}
}
