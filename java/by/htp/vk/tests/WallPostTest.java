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
	public void A_createWallPostTest() {
		steps.loginToVk();
		steps.goToMyPage();
		wallPostCountBefore = steps.getWallPostCount();
		Assert.assertTrue(steps.wallPost(), "Wall post wasnt created");
	}

	@Test
	public void B_likeWallPostTest() {
		Assert.assertTrue(steps.clickLikePost(), "Post wasnt liked");
	}

	@Test
	public void C_editWallPostTest() {
		Assert.assertTrue(steps.edidWallPost(), "Post wasnt edited");
	}

	@Test
	public void D_addCommentWallPostTest() {
		Assert.assertTrue(steps.addComment(), "Comment wasnt created");
	}

	@Test
	public void E_deleteWallPostTest() {
		steps.deleteWallPost();
		wallPostCountAfer = steps.getWallPostCount();
		Assert.assertEquals(wallPostCountBefore, wallPostCountAfer);
	}

	@AfterClass
	public void afterClass() {
		steps.closeDriver();
	}

}
