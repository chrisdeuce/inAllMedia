/**
 * 
 */
package com.inallmedia.page;

import java.util.Iterator;
import java.util.List;
/**
 * @author Felix Ruiz 
 *
 */
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

public class InallMediaLanding {
	JavascriptExecutor js;
	 WebDriverWait waitDriver;
	 
	 public InallMediaLanding(WebDriver driver){
			PageFactory.initElements(driver,this);
			this.js=(JavascriptExecutor)driver;
			this.waitDriver = new WebDriverWait(driver, 15); 
	 }
	 
	 //locators
	 @FindBy (how=How.XPATH,using="/html/body/iam-footer/section[1]/div[1]/a/img") 
	 @CacheLookup
	 WebElement logoMedia;
	 
	 @FindBy (how=How.CLASS_NAME,using="ng-isolate-scope")
	 @CacheLookup
	 WebElement links;
	 
	 public boolean logo(){
		try{
			waitDriver.until(ExpectedConditions.visibilityOf(logoMedia));
			waitDriver.until(ExpectedConditions.elementToBeClickable(logoMedia));
			System.out.println("Logo is displayed and enabled in allmedia page" );
			return true;
		}
		catch(NoSuchElementException e){
			System.out.println("Exception throwed: " + e);
			return false;
		}
		catch(StaleElementReferenceException f){
			System.out.println("Stale element reference exception throwed: " + f);
			return false;
		}
	 }
	 
	 public void scrollUpDw(String value){
	    	js.executeScript("window.scrollBy(0,"+ value + " )"); 
	    }
	 
	 public void findingLogo(String href){
	    	List <WebElement> results = links.findElements(By.tagName("a"));
	    	Iterator <WebElement> i = results.iterator();
	    	
	    	while(i.hasNext()){
	    		WebElement anchor = i.next();
	    		if(anchor.getAttribute("href").contains(href)){
	    			//anchor.click();
	    			System.out.println(anchor.getAttribute("src"));
	    			anchor.click();
	    			break;
	    		}
	    	}
	    }

}
