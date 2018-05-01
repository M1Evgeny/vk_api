package by.htp.vk.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.vk.api.VkApi;
import by.htp.vk.driver.DriverSingleton;
import by.htp.vk.pages.LoginPage;
import by.htp.vk.pages.MessagesPage;
import by.htp.vk.pages.NewsPage;
import by.htp.vk.pages.UserPage;

public class Steps {

	private String message = "test message";
	private String editMessage = "edit test message";
	private String comment = "test comment";
	private String one = "1";

	private WebDriver driver;
	private VkApi api;

	private static final Logger logger = LogManager.getLogger();

	public void initDriver() {
		driver = DriverSingleton.getDriver();
		api = new VkApi();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginToVk() {
		LoginPage page = new LoginPage(driver);
		page.openPage();
		page.inputLogin();
		page.inputPass();
		page.submitLogin();
		logger.info("Login performed");
	}

	public void goToMyPage() {
		NewsPage page = new NewsPage(driver);
		page.goToMyPage();
	}

	public void goToMessages() {
		NewsPage page = new NewsPage(driver);
		page.goToMesseges();
	}

	public String getWallPostCount() {
		api.getWallPostCount();
		return api.getPostCount();
	}

	public String getMessageCount() {
		api.getMessageCount();
		return api.getMessagesCount();
	}

	public boolean wallPost() {
		api.createPost(message);
		UserPage page = new UserPage(driver, api.getPostId());
		logger.info("Wall post was created");
		return page.cheackText(message);
	}

	public boolean edidWallPost() {
		api.editPost(api.getPostId(), editMessage);
		UserPage page = new UserPage(driver, api.getPostId());
		logger.info("Wall post was edited");
		return page.cheackText(editMessage);
	}

	public boolean clickLikePost() {
		UserPage page = new UserPage(driver, api.getPostId());
		page.likePost();
		logger.info("Wall post was liked");
		return page.getlikeCount().getText().equals(one);
	}

	public boolean addComment() {
		api.createComment(api.getPostId(), comment);
		logger.info("Comment was created to the wall post");
		UserPage page = new UserPage(driver, api.getPostId());
		return page.cheackCommentText(comment);
	}

	public void deleteWallPost() {
		api.deletePost(api.getPostId());
		logger.info("Wall post was deleted");
	}

	public boolean sendUserMessage() {
		api.sendMessage(message);
		MessagesPage mPage = new MessagesPage(driver, api.getMessageId());
		logger.info("Message was sent");
		return mPage.getMessageText().equals(message);
	}

	public void deleteUserMessage() {
		api.deleteMessage(api.getMessageId());
		logger.info("Message was deleted");
	}
}
