package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AmazonLite {
	 public static void main(String[] args) throws Exception{
	    	AppiumDriver<MobileElement> driver = GenericClass.getDriver();
	    	
	    	GenericClass.lauchApp();
	    	GenericClass.waitForPageLoad(10000);
            Thread.sleep(5000);
	    	try{
	    	if(GenericClass.isElementPresent(AppiumConstantsAmazonLite.SEARCH_TEXT_BOX, "Search Text Box")){
	    		GenericClass.waitForElementToAppear(AppiumConstantsAmazonLite.SIGN_IN_BUTTON, 1000, "SignIn");
	    		GenericClass.click(AppiumConstantsAmazonLite.SIGN_IN_BUTTON, "SignIn");
	    		GenericClass.driverWait(40);
	    	    GenericClass.waitForPageLoad(5000);
	    	
	    	if(GenericClass.isElementPresent(AppiumConstantsAmazonLite.WELCOME_MESSAGE, "msg")){
	    		GenericClass.waitForElementToAppear(AppiumConstantsAmazonLite.LOGIN_RADIO, 1000, "Login radio");
	    		GenericClass.click(AppiumConstantsAmazonLite.LOGIN_RADIO, "Login radio");
	    		GenericClass.driverWait(20);
	    		GenericClass.type(AppiumConstantsAmazonLite.EMAIL,"aashitadutta@gmail.com", "Email");
	    		//GenericClass.waitForElementToAppear(AppiumConstantsAmazonLite.CONTINUE_BUTTON, 10000, "Continue");
	    		WebElement el = driver.findElement(By.xpath(AppiumConstantsAmazonLite.CONTINUE_BUTTON));
	    		//Actions action = new Actions(driver);
	    		//action.moveToElement(el).click().perform();
	    		//GenericClass.click(AppiumConstantsAmazonLite.MESSAGE, "Continue");
	            
	    		el.click();
	            GenericClass.click(AppiumConstantsAmazonLite.CONTINUE_BUTTON, "Continue");
	            GenericClass.waitForPageLoad(5000);
	    	
	    	if(GenericClass.isElementPresent(AppiumConstantsAmazonLite.LOGIN_MESSAGE, "login message")){
	    		GenericClass.waitForElementToAppear(AppiumConstantsAmazonLite.EMAIL_MESSAGE, 500, "email message");
	    		
	    		String message = GenericClass.getText(AppiumConstantsAmazonLite.EMAIL_MESSAGE, "email message");
	    		if(message.contentEquals("aashitadutta@gmail.com")){
	    			System.out.println("Email matched");
	    		}
	    		GenericClass.type(AppiumConstantsAmazonLite.PASSWORD,"", "Password");
	    		GenericClass.driverWait(40);
	            GenericClass.click(AppiumConstantsAmazonLite.LOGIN_BUTTON, "Login button");
	            GenericClass.waitForPageLoad(5000);
	        }
	    	else {
	    		System.out.println("Login message not appeared");
	    	}
	       }
	    	else {
	    		System.out.println("welcome message not appeared");
	    	}
	       }
	    	else{
	    	   System.out.println("Problem signing in"); 
	    	}
	       }
	    	catch(Exception e){
	    		if(GenericClass.isElementPresent(AppiumConstantsAmazonLite.SEARCH_TEXT_BOX, "Search Text Box")){
	    	    GenericClass.type(AppiumConstantsAmazonLite.SEARCH_TEXT_BOX,"Bluetooth Speakers", "Search Text Box");
	    		GenericClass.driverWait(40);
	            //GenericClass.waitForElementToAppear(AppiumConstants.SIGN_IN_BUTTON, 40, "sign in button");
	    		GenericClass.click(AppiumConstantsAmazonLite.GO_BUTTON, "Go button");
	            //System.out.println(e.getMessage());
	    		}
	         }
	    }
	 }

