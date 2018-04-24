package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommentWallPostTest {
	private Steps steps;

	@BeforeClass
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
		steps.loginToVk();
		steps.goToMyPage();
		steps.wallPost();
	}

	@Test
	public void commentWallPostTest() {
		Assert.assertTrue(steps.addComment(), "Comment wasn't created");
	}

	@AfterClass
	public void afterClass() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
