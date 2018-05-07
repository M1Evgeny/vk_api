package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditWallPostTest {
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
	public void editWallPostTest() {
		Assert.assertTrue(steps.edidWallPost(), "Post wasn't edited");
	}

	@AfterMethod
	public void tearDown() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
