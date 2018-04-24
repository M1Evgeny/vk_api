package by.htp.vk.pages;

import static by.htp.vk.utils.PropertiesManager.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPage extends AbstractPage {

	private String baseLocator = "//div[@id='wpt%s_%s']";
	private String like = "//div[@id='post%s_%s']//i[@class='post_like_icon _icon']";
	private String likeCount = "//div[@id='post%s_%s']//span[@class='post_like_count _count']";
	private String comment = "//div[@class='wall_reply_text']";
	private String userId = getProperty("vk.userId");
	By newMessege;
	By likePost;
	By likeCountPost;
	By postComment = By.xpath(comment);

	public UserPage(WebDriver driver, String id) {
		super(driver);
		newMessege = By.xpath(String.format(baseLocator, userId, id));
		likePost = By.xpath(String.format(like, userId, id));
		likeCountPost = By.xpath(String.format(likeCount, userId, id));
	}

	@Override
	public void openPage() {
	}

	public boolean cheackText(String text) {
		return wait.until(ExpectedConditions.textToBe(newMessege, text));
	}

	public void likePost() {
		wait.until(ExpectedConditions.elementToBeClickable(likePost)).click();
	}

	public WebElement getlikeCount() {
		return wait.until(ExpectedConditions.elementToBeClickable(likeCountPost));
	}

	public boolean cheackCommentText(String commentMessage) {
		return wait.until(ExpectedConditions.textToBe(postComment, commentMessage));
	}

}
