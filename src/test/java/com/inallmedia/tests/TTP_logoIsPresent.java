/**
 * 
 */
package com.inallmedia.tests;

/**
 * @author Felix Ruiz Mendoza
 *
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.page.GoogleHomePage;
import com.inallmedia.page.*;
import helper.BrowserFactory;

public class TTP_logoIsPresent {
	private static WebDriver driver;
	static String browser;
	static String url="http://www.google.com";
	
	@BeforeTest
	public void setup(){
		browser = "chrome";
		driver = BrowserFactory.startBrowser(browser, url);
	}
	
	@Test
	public void verifylogo(){
		GoogleHomePage searchPage = new GoogleHomePage(driver);
		InallMediaLanding inAllMedia = new InallMediaLanding(driver);
		String title = driver.getTitle();
		boolean logoIsDisplayed;
	    Assert.assertTrue(title.contains("Google"));
	    searchPage.search("in all media");
	    System.out.println("Search done");
	    searchPage.listLinks("http://inallmedia.com/");
	    inAllMedia.scrollUpDw("3200");
	    logoIsDisplayed = inAllMedia.logo();
	    if(logoIsDisplayed){
	    	System.out.println("Logo is present within page footer");
	    	Assert.assertEquals(1,1);
	    }else{
	    	System.out.println("Logo is notpresent within page footer");
	    	Assert.assertEquals(1,0);
	    }
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
}
