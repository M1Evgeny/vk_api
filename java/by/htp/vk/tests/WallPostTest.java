package by.htp.vk.tests;

import org.testng.annotations.Test;

import by.htp.vk.steps.Steps;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class WallPostTest {
	private Steps steps;
	private String wallPostCountBefore;
	private String wallPostCountAfer;

	@BeforeClass
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
	}

	@Test
	public void createWallPostTest() {
		steps.loginToVk();
		steps.goToMyPage();
		wallPostCountBefore = steps.getWallPostCount();
		Assert.assertTrue(steps.wallPost(), "Wall post wasnt created");
	}

	@Test (dependsOnMethods = { "createWallPostTest" })
	public void likeWallPostTest() {
		Assert.assertTrue(steps.clickLikePost(), "Post wasnt liked");
	}

	@Test (dependsOnMethods = { "likeWallPostTest" })
	public void editWallPostTest() {
		Assert.assertTrue(steps.edidWallPost(), "Post wasnt edited");
	}

	@Test (dependsOnMethods = { "createWallPostTest" })
	public void addCommentWallPostTest() {
		Assert.assertTrue(steps.addComment(), "Comment wasnt created");
	}

	@Test (dependsOnMethods = { "createWallPostTest" })
	public void deleteWallPostTest() {
		steps.deleteWallPost();
		wallPostCountAfer = steps.getWallPostCount();
		Assert.assertEquals(wallPostCountBefore, wallPostCountAfer);
	}

	@AfterClass
	public void afterClass() {
		steps.closeDriver();
	}

}
