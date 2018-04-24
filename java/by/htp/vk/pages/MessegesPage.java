package by.htp.vk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessegesPage extends AbstractPage {
	
	private String messageLocator = "//li[@data-msgid='%s']//span[@class='nim-dialog--preview _dialog_body']";
	By messageText;

	public MessegesPage(WebDriver driver, String messageId) {
		super(driver);
		messageText= By.xpath(String.format(messageLocator, messageId));
	}

	@Override
	public void openPage() {
	}
	
	public String getMessageText() {
		return wait.until(ExpectedConditions.elementToBeClickable(messageText)).getText();
	}

}
