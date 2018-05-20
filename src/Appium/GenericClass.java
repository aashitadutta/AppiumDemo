package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class GenericClass {
	
	//public static AndroidDriver<MobileElement> driver; 
	public static  AppiumDriver<MobileElement> driver;
    //public static void main(String[] args) throws MalformedURLException{
	public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException{
    File app  = new File("D:/eclipse-android-neon-RC1-win32-x86_64/sdk/platform-tools/Amazon_App.apk");
	
    DesiredCapabilities capabilities = new DesiredCapabilities();	
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Oppo");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability("autoGrantPermissions","true");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.venezia");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.venezia.Launcher");
    capabilities.setCapability("noReset", "true");
    capabilities.setCapability("newCommandTimeout", 100000);
    capabilities.setCapability("autoLaunch",false);
    
    driver = new AppiumDriver<>(
    		new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	System.out.println("Activity launched");
    
	
	return driver;
	}
	
	public static void lauchApp() throws Exception{
		driver.launchApp();
	}
	
	public static void click(String locator, String elementName) throws Exception{
		driver.findElement(By.xpath(locator)).click();
		
		System.out.println("Element " + elementName + " is clicked");
	}
	
	public static void driverWait(long time) throws Exception{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void type(String locator, String value, String elementName) throws Exception{
		driver.findElement(By.xpath(locator)).sendKeys(value);
		System.out.println("Gonna type " + value + " in " + elementName);
	}
	
	public static boolean isElementPresent(String locator, String elementName) throws Exception{
		boolean flag = false;
		
		if(driver.findElement(By.xpath(locator)).isDisplayed()){
			System.out.println("Element " + elementName + " is present");
			flag = true;
		}
		else{
			System.out.println("Element " + elementName + " is not present");
			}
		return flag;
		
	}
	
	public static void waitForPageLoad(long time) throws InterruptedException{
		Thread.sleep(time);
	}
    
	public static void waitForElementToAppear(String locator, long time, String elementName) throws Exception{
		WebDriverWait driverWait = new WebDriverWait(driver, time);
		driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		WebElement element = driver.findElement(By.xpath(locator));
		if(element.isDisplayed()){
			System.out.println(element + " is displayed");
			
		}
		else{
			System.out.println(element + " is not displayed");
		}
	}
	
	public static String getText(String locator, String elementName) throws Exception{
		String text  = driver.findElement(By.xpath(locator)).getText();
		System.out.println("Text for " + elementName + "is: "+text);
		return text;
		
	}
}
