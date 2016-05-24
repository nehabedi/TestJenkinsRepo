package pack1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewTest
{
 private static RemoteWebDriver driver = null;
    
  public boolean takeScreenshot(final String name)
  {
	  String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
  
  @BeforeMethod
  public void setUp() throws Exception 
  {
      DesiredCapabilities capabilities = new DesiredCapabilities();
          URL url = new URL("http://localhost:4723/wd/hub");
          driver = new RemoteWebDriver(url, capabilities);
  }
  
  @Test
  public void firstT() 
  {
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
	  boolean exists = driver.findElements(By.id("login")).size()!=0;
	//  Reporter.log("Clicked on Skip Sign In Button!!");
	  if (exists==true)
	  {
		  Reporter.log("Button Exists!!!");
	  }
		 
	  else 
	  {
		  Reporter.log("button doesn't exists!!");
		  Assert.fail("Error - Button Not Found! ");
	  }
		  
	  String screenshot1 = "firstT";
	  takeScreenshot(screenshot1);
  }
  
  @Test
  public void secondT() 
  {
	 Assert.fail("Failing Test Case for Testing Purpose.- NOT A VALID FAILURE - IGNORE!!!");
  }
  
  @AfterMethod
  public static void tearDownClass() 
  {
      if (driver != null) 
      {
         driver.quit();
      }
  }
}

