package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;

public class CommentWallPostTest {
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
	public void commentWallPostTest() {
		Assert.assertTrue(steps.addComment(), "Comment wasn't created");
	}

	@AfterMethod
	public void tearDown() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
