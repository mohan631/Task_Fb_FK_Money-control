package com.money_control;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {

@BeforeClass
	@DataProvider(name = "testData")
	public Object[] testData() {
	    return new Object[][] {
	        { "user1"  },
	        { "user2" },
	        { "user3" }
	    };
	}
	@Test(dataProvider = "testData")
	public void loginTest(String username) {
	   System.out.println("jsfhjsf"+username);
	   System.out.println("password");
	}

}
