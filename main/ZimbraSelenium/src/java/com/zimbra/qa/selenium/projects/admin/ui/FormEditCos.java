package com.zimbra.qa.selenium.projects.admin.ui;

import com.zimbra.qa.selenium.framework.items.IItem;
import com.zimbra.qa.selenium.framework.ui.AbsApplication;
import com.zimbra.qa.selenium.framework.ui.AbsForm;
import com.zimbra.qa.selenium.framework.util.HarnessException;


public class FormEditCos extends AbsForm {

	public static class TreeItem {
		public static final String GENERAL_INFORMATION="General Information";
	}
	
	public static class Locators {
		public static final String NAME_TEXT_BOX="css=input#ztabv__COS_EDIT_";
		public static final String SAVE_BUTTON="css=td[id^='zb__ZaCurrentAppBar__SAVE']";
		public static final String CLOSE_BUTTON="css=td[id^='zb__ZaCurrentAppBar__CLOSE']";
	}

	public FormEditCos(AbsApplication application) {
		super(application);
		
		logger.info("new " + myPageName());

	}

	@Override
	public boolean zIsActive() throws HarnessException {

		// Make sure the Admin Console is loaded in the browser
		if ( !MyApplication.zIsLoaded() )
			throw new HarnessException("Admin Console application is not active!");

		
		boolean present = sIsElementPresent("");
		if ( !present ) {
			return (false);
		}
		
		String attrs = sGetAttribute("");
		if ( !attrs.contains("ZSelected") ) {
			return (false);
		}

		return (true);
		
	}

	@Override
	public String myPageName() {
		return (this.getClass().getName());
	}

	@Override
	public void zFill(IItem item) throws HarnessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zSubmit() throws HarnessException {
		sClickAt(Locators.SAVE_BUTTON,"");
		sClickAt(Locators.CLOSE_BUTTON,"");
	}
	
	public void zClickTreeItem(String treeItem) throws HarnessException {
		sClickAt("css=td:contains('" + treeItem + "')", "");
	}
	
	public void setName(String name) throws HarnessException {
		for(int i=10;i>=2;i--) {
			if(sIsElementPresent(Locators.NAME_TEXT_BOX+i+"_cn_2")) {
				sType(Locators.NAME_TEXT_BOX+i+"_cn_2", name);
				return;
			}
		}
		sType(Locators.NAME_TEXT_BOX+"cn_2", name);
		}
	}

