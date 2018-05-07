package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LikeWallPostTest {
	private Steps steps;

	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initDriver();
		steps.loginToVk();
		steps.goToMyPage();
		steps.wallPost();
	}

	@Test
	public void likeWallPostTest() {
		Assert.assertTrue(steps.clickLikePost(), "Post wasn't liked");
	}

	@AfterMethod
	public void tearDown() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
