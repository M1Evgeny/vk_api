package by.htp.vk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private int timeOutInSeconds = 10;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, timeOutInSeconds);
	}

	public abstract void openPage();

	public WebElement getElement(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
