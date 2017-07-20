package deviceoverview779;



	import io.appium.java_client.android.AndroidDriver;

	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import java.util.concurrent.*;
	public class Launch_App {
		  private static AndroidDriver driver;

		    @BeforeTest
		    public void setUp() throws Exception {
		    	System.out.println("setUp()");
		    	DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability("deviceName","Moto G");
		        capabilities.setCapability("platformVersion", "4.4");
		        //capabilities.setCapability("app", app.getAbsolutePath());
		        capabilities.setCapability("appPackage", "com.coho");
		        capabilities.setCapability("appActivity", "com.coho.MainActivity");
		        
		        driver = new AndroidDriver(new URL("http://0.0.0.1:4733/wd/hub"), capabilities);
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    }
		    
		    @Test
		    public void basicLoginTest() throws MalformedURLException{
		        driver.findElementByName(Keywords.SignIn).click();
		        List<WebElement> ele = driver.findElementsByClassName("android.widget.EditText");
		        ele.get(0).sendKeys(Variables.USER_NAME);
		        ele.get(1).sendKeys(Variables.PASSWORD);
		        driver.findElementByXPath(Keywords.Login).click();
		        driver.findElementByName(Keywords.MyHome);
		    }
		    //verifying the device connected to the user
		    @Test
		    public void deviceNPDIAD_779_TC_02Test(){
		    	driver.findElementByXPath(Keywords.Hamburger).click();
		    	driver.findElementByName(Keywords.Devices).click();
		    	driver.findElementByName(Keywords.Devices);
		    	//No devices are connected to user, so not able to verify the connected devices
		    	List active = driver.findElementsByXPath(Keywords.ActiveDevices);
		    	if(active.size() >= 1)
		    	{
		    		System.out.println("User has active devices");
		    	}
		    }
		    //verifying the virtual device groups connected to the user
		    @Test
		    public void deviceNPDIAD_779_TC_03Test(){
		    	driver.findElementByName(Keywords.Devices);
		    	//No devices are connected to user, so not able to verify the connected devices
		    	List active = driver.findElementsByXPath(Keywords.ActiveDevices);
		    	if(active.size() >= 1)
		    	{
		    		System.out.println("User has active devices");
		    	}
		    }
		  //After scroll over the screen, user should be able to see the hidden content (Connected devices and created groups)
		    @Test
		    public void deviceNPDIAD_779_TC_04Test(){
		    	driver.findElementByName(Keywords.Devices);
		    	//No devices are connected to user, so not able to verify the connected devices
		    	List active = driver.findElementsByXPath(Keywords.ActiveDevices);
		    	if(active.size() >= 1)
		    	{
		    		System.out.println("User has active devices");
		    	}
		    }
		  //User should return to homescreen
		    @Test
		    public void deviceNPDIAD_779_TC_11Test(){
		    	driver.findElementByName(Keywords.Devices);
		    	//When i use the device back icon. its exiting the application i am using the menu icon
		    	//driver.pressKeyCode(4);
		    	driver.findElementByXPath(Keywords.Hamburger1).click();
		    	driver.findElementByName(Keywords.Home).click();
		    }
		    
		  //Verify that user should be able to see all the devices that are added in the group
		    @Test
		    public void deviceNPDIAD_779_TC_07Test(){
		    	driver.findElementByName(Keywords.Devices);
		  
		    	List active = driver.findElementsByXPath(Keywords.ActiveDevices);
		    	if(active.size() >= 1)
		    	{
		    		System.out.println("User has active devices");
		    	}
		    }
		    
		  //User should able to re-arrange all device or group cards by drag and drop
		    @Test
		    public void deviceNPDIAD_779_TC_14Test(){
		    	driver.findElementByName(Keywords.Devices);
		    	//user should able to check the active devices
		    	List active = driver.findElementsByXPath(Keywords.ActiveDevices);
		    	if(active.size() >= 1)
		    	{
		    		System.out.println("User has active devices");
		    	}
		    }
		    @AfterTest
		    public void tearDown(){
		    	 driver.quit();
		    }
	}
