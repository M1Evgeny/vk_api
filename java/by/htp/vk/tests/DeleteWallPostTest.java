package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteWallPostTest {
	private Steps steps;
	private String wallPostCountBefore;
	private String wallPostCountAfer;

	@BeforeMethod
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
		steps.loginToVk();
		steps.goToMyPage();
		wallPostCountBefore = steps.getWallPostCount();
		steps.wallPost();
	}

	@Test
	public void deleteWallPostTest() {
		steps.deleteWallPost();
		wallPostCountAfer = steps.getWallPostCount();
		Assert.assertEquals(wallPostCountBefore, wallPostCountAfer, "Wall post wasn't deleted");
	}

	@AfterMethod
	public void afterClass() {
		steps.closeDriver();
	}

}
