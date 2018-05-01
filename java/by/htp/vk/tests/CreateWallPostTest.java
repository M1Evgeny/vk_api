package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateWallPostTest {
	private Steps steps;

	@BeforeMethod
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
	}

	@Test
	public void createWallPostTest() {
		steps.loginToVk();
		steps.goToMyPage();
		Assert.assertTrue(steps.wallPost(), "Wall post wasn't created");
	}

	@AfterMethod
	public void afterClass() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
