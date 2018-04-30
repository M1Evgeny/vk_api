package by.htp.vk.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingleton {

	private static WebDriver driver;
	private static final Logger logger = LogManager.getLogger();
	private static final int PAGE_LOAD_TIMEOUT = 10;

	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

	private static void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Browser started");
	}

}
