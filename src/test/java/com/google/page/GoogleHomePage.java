/**
 * 
 */
package com.google.page;

import org.openqa.selenium.By;

/**
 * @author Felix Ruiz 
 *
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class GoogleHomePage {
	JavascriptExecutor js;
	 WebDriverWait waitDriver;
	 
	 public GoogleHomePage (WebDriver driver){
			PageFactory.initElements(driver,this);
			this.js=(JavascriptExecutor)driver;
			this.waitDriver = new WebDriverWait(driver, 15); 
	   }
	 
	 //locators
	    @FindBy (how=How.NAME,using="q")
		@CacheLookup
		WebElement search;
	    
	    @FindBy (how=How.CSS,using="input[type=submit]")
	    @CacheLookup
	    WebElement button;
	    
	    @FindBy (how=How.ID,using="res")
	    @CacheLookup
	    WebElement links;
	    
	    
	    public void search(String busqueda){
	    	waitDriver.until(ExpectedConditions.elementToBeClickable(search));
	    	search.click();
	    	search.sendKeys(busqueda);
	    	button.click();
	    }
	    
	    public void listLinks(String href){
	    	List <WebElement> results = links.findElements(By.tagName("a"));
	    	Iterator <WebElement> i = results.iterator();
	    	
	    	while(i.hasNext()){
	    		WebElement anchor = i.next();
	    		if(anchor.getAttribute("href").contains(href)){
	    			anchor.click();
	    			break;
	    		}
	    	}
	    }
	    
}
