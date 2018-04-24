package by.htp.vk.pages;

import static by.htp.vk.utils.PropertiesManager.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
	private final String URL = "https://vk.com/";
	private String userLogin = getProperty("vk.login");
	private String userPass = getProperty("vk.pass");
	By txbLogin = By.xpath("//input[@id='index_email']");
	By txbPass = By.xpath("//input[@id='index_pass']");
	By btnSubmit = By.xpath("//button[@id='index_login_button']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(URL);
	}

	public void inputLogin() {
		getElement(txbLogin).sendKeys(userLogin);
	}

	public void inputPass() {
		getElement(txbPass).sendKeys(userPass);
	}

	public void submitLogin() {
		getElement(btnSubmit).click();
	}

}
