package by.htp.vk.tests;

import by.htp.vk.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditWallPostTest {
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
	public void editWallPostTest() {
		Assert.assertTrue(steps.edidWallPost(), "Post wasn't edited");
	}

	@AfterClass
	public void afterClass() {
		steps.deleteWallPost();
		steps.closeDriver();
	}

}
