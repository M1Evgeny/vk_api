package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateWallPostTest {
	private Steps steps;

	@BeforeClass
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

	@AfterClass
	public void afterClass() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
