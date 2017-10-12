package com.rectrix.groupworkflow.logindex;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rectrix.groupworkflow.UiActions.Homepage;
import com.rectrix.groupworkflow.testbase.Testbase;

public class Logindex extends Testbase {
	
	Homepage home;
	
	@BeforeClass
	public void startWebApps() throws IOException{
		
		init();
	}
	
	@Test
	public void userLogin(){
		
	 home = new Homepage(driver);
	 home.login();
	 home.logout();
	}
	
	
	@AfterClass
	public void closeWebApps(){
		
		driver.close();
	}
}
