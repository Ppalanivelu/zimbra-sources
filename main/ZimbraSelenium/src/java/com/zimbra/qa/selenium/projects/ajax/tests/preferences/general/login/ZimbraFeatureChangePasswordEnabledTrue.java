package com.zimbra.qa.selenium.projects.ajax.tests.preferences.general.login;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.zimbra.qa.selenium.framework.core.Bugs;
import com.zimbra.qa.selenium.framework.ui.Action;
import com.zimbra.qa.selenium.framework.util.HarnessException;
import com.zimbra.qa.selenium.framework.util.ZAssert;
import com.zimbra.qa.selenium.projects.ajax.core.AjaxCommonTest;
import com.zimbra.qa.selenium.projects.ajax.ui.preferences.TreePreferences.TreeItem;

public class ZimbraFeatureChangePasswordEnabledTrue extends AjaxCommonTest {

	@SuppressWarnings("serial")
	public ZimbraFeatureChangePasswordEnabledTrue() {
		logger.info("New "+ ZimbraFeatureChangePasswordEnabledTrue.class.getCanonicalName());

		// All tests start at the login page
		super.startingPage = app.zPagePreferences;

		super.startingAccountPreferences = new HashMap<String, String>() {
			{

				// Options/Preferences is disabled
				put("zimbraFeatureChangePasswordEnabled", "TRUE");

			}
		};

	}
	
	/**
	 * @throws HarnessException
	 */
	@Bugs(ids="63439")	
	@Test(
			description = "Verify the 'Change Password' option is present in preferences", 
			groups = { "functional" }
			)
	public void ZimbraFeatureChangePasswordEnabledTrue_01() throws HarnessException {
				
		// Go to "General"
		app.zTreePreferences.zTreeItem(Action.A_LEFTCLICK, TreeItem.General);
		
		String labelLocator = "//div[@id='CHANGE_PASSWORD']/../../td[@class='ZOptionsLabel']";
		String fieldLocator = "//div[@id='CHANGE_PASSWORD']";
	
		ZAssert.assertTrue(
				app.zTreePreferences.sIsElementPresent(labelLocator), 
				"Verify the 'change password' label is present");
	
		ZAssert.assertTrue(
				app.zTreePreferences.sIsElementPresent(fieldLocator), 
				"Verify the 'change password' field is present");

	}
}