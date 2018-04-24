package by.htp.vk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsPage extends AbstractPage {

	By myPageBtn = By.xpath("//li[@id='l_pr']");
	By messeges = By.xpath("//li[@id='l_msg']");

	public NewsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
	}

	public void goToMyPage() {
		getElement(myPageBtn).click();
	}

	public void goToMesseges() {
		wait.until(ExpectedConditions.elementToBeClickable(messeges)).click();
	}

}
