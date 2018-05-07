package by.htp.vk.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.vk.steps.Steps;

import org.testng.Assert;


public class MessageSendTest {
	private String messageCountBefore;
	private String messageCountAfer;
	private Steps steps;

	@BeforeMethod
	public void beforeClass() {
		steps = new Steps();
		steps.initDriver();
	}

	@Test
	public void testMessage() {
		steps.loginToVk();
		steps.goToMessages();
		messageCountBefore = steps.getMessageCount();
		Assert.assertTrue(steps.sendUserMessage(), "Message wasn't sent");
		steps.deleteUserMessage();
		messageCountAfer = steps.getMessageCount();
		Assert.assertEquals(messageCountBefore, messageCountAfer, "Message wasn't deleted");
	}

	@AfterMethod
	public void afterClass() {
		steps.closeDriver();
	}

}
