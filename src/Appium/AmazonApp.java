package Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AmazonApp {
    public static void main(String[] args) throws Exception{
    	AppiumDriver<MobileElement> driver = GenericClass.getDriver();
    	
    	GenericClass.lauchApp();
    	GenericClass.waitForPageLoad(10000);

    	Thread.sleep(5000);
    	WebElement signUpButton = driver.findElement(By.xpath(AppiumConstants.SIGN_UP_BUTTON));
    	if(GenericClass.isElementPresent(AppiumConstants.SIGN_UP_BUTTON, "SignUp")){
    		GenericClass.click(AppiumConstants.SIGN_UP_BUTTON, "SignUp");
    		GenericClass.driverWait(40);
    	}
    	
    	if(GenericClass.isElementPresent(AppiumConstants.NAME, "name")){
    		GenericClass.type(AppiumConstants.NAME,"Aashita Dutta", "name");
    		GenericClass.driverWait(20);
    		GenericClass.type(AppiumConstants.EMAIL,"aashitadutta@gmail.com", "email");
    		GenericClass.driverWait(20);
    		GenericClass.type(AppiumConstants.PASSWORD,"Russia@2018", "email");
    		GenericClass.driverWait(20);
            GenericClass.click(AppiumConstants.CREATE_ACCOUNT_BUTTON, "create account button");
            GenericClass.driverWait(40);
    		
    	}
    	GenericClass.waitForPageLoad(5000);
        
    	if(GenericClass.isElementPresent(AppiumConstants.ERROR_MESSAGE, "error message")){
    		GenericClass.driverWait(40);
    		GenericClass.getText(AppiumConstants.ERROR_MESSAGE, "error message");
    		GenericClass.waitForElementToAppear(AppiumConstants.SIGN_IN_BUTTON, 40, "sign in button");
    		GenericClass.click(AppiumConstants.SIGN_IN_BUTTON, "sign in button");
        }
    	GenericClass.waitForPageLoad(5000);
        
    }
}
