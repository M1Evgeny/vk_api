package by.htp.vk.tests;

import org.testng.annotations.Test;

import by.htp.vk.steps.Steps;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MessgeSendTest {
	private String messageCountBefore;
	private String messageCountAfer;
	private Steps steps;

	@BeforeClass
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
	}

	@Test
	public void testMessege() {
		steps.loginToVk();
		steps.goToMesseges();
		messageCountBefore = steps.getMessageCount();
		Assert.assertTrue(steps.sendUserMessage(), "Message wasnt sent");
		steps.deleteUserMessage();
		messageCountAfer = steps.getMessageCount();
		Assert.assertEquals(messageCountBefore, messageCountAfer);
	}

	@AfterClass
	public void afterClass() {
		steps.closeDriver();
	}

}
