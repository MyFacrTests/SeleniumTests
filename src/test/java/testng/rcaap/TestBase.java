package testng.rcaap;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();
	protected boolean acceptNextAlert = true;
	
	@Parameters({"browser", "os"})// this annotation is used to insert browser parameter from TestNG xml or from maven
	//@Parameters("browser")// this annotation is used to insert browser parameter from TestNG xml or from maven
	@BeforeClass(alwaysRun = true)
    public void setUp(String browser, @Optional("windows") String os) throws Exception {
    
	  String operatingSystem = os.equalsIgnoreCase("linux") ? os : "windows";
	  System.out.println("OS: " + operatingSystem);
	  String path = "driver/" + operatingSystem;
		
	 if(browser.equalsIgnoreCase("firefox")){
		 path += "/geckodriver" + (operatingSystem.equalsIgnoreCase("windows") ? ".exe" : "");
		  System.setProperty("webdriver.gecko.driver", path );
		  //System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		  path += "/chromedriver" + (operatingSystem.equalsIgnoreCase("windows") ? ".exe" : "");
		  System.setProperty("webdriver.chrome.driver", path);
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("headless")){
		  //Enable Javascript = true
		  driver = new HtmlUnitDriver(true);
		  
	  }
	  /*else if(browser.equalsIgnoreCase("phantom")){
		  DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setJavascriptEnabled(true);
		  cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "driver/windows/phantomjs.exe");
		  driver = new PhantomJsDriver();
		  
	  }*/
	  else{
		  // OH NOEZ! I DOAN HAZ DAT BROWSR!
		  System.out.println("Cannot find suitable browser driver for ["+ browser +"]");
		  System.err.println("Cannot find suitable browser driver for ["+ browser +"]");
		  throw new Exception("Cannot find suitable browser driver for ["+ browser +"]");
	  }

   //Parameterization of implicit wait
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

	
	//Should be in the super class
	  @AfterClass(alwaysRun = true)
	 // @AfterMethod()
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	  
	  protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  protected boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
