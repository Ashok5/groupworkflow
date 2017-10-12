package com.rectrix.groupworkflow.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Testbase {
	
	protected WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	String browser = "chrome";
	String url = "http://localhost:9000/GroupWorkflow/login";
	Properties OR;
	
	public void loaddata() throws IOException{
		
		try {
			OR = new Properties();
			File file = new File(System.getProperty("user.dir")+"//src//main//java//com//rectrix//groupworkflow//Config/config.properties");
			InputStream f = new FileInputStream(file);
			OR.load(f);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void init(){
		
	//	String log4jConfpath = "log4j.properties";
	//	PropertyConfigurator.configure(log4jConfpath);
		extent = new ExtentReports(System.getProperty("user.dir")+"//src//main//java//com//rectrix//groupworkflow//report//report.html",false);
		selectBrowser(browser);
		getUrl(url);
	}
	
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe" );
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-extensions");
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--js-flags=--expose-gc");  
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
		
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);   
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
					
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//driver//geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//driver//IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);  
			
		}
		
	}
	
	public void getUrl(String url){
		
		driver.get(url);
		
	}
	
}
