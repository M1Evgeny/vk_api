package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteWallPostTest {
	private Steps steps;
	private String wallPostCountBefore;
	private String wallPostCountAfer;

	@BeforeClass
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

	@AfterClass
	public void afterClass() {
		steps.closeDriver();
	}

}
