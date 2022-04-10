package com.qa.stepdef;

import java.io.IOException;

import com.qa.util.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	
	@Before
	public void initializedriver() throws Exception {
		new BaseClass().Initialize();
	}
	
	@After
	public void quit() throws IOException {
		new BaseClass().getDriver().quit();
	}
}
