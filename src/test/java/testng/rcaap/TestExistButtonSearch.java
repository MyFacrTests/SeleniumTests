package testng.rcaap;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestExistButtonSearch {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String url;
	  
	   @Parameters("browser")// this annotation is used to insert browser parameter from TestNG xml
	    @BeforeClass(alwaysRun = true)
	    //@BeforeMethod //The annotated method will be run before all tests in this suite have run 
	    public void setUp(String browser) throws Exception {
		  if(browser.equalsIgnoreCase("firefox")){
			  System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			  driver = new FirefoxDriver();
		  }
		  else if(browser.equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			  driver = new ChromeDriver();
		  }
		  else{
			  System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			  driver = new FirefoxDriver();
			  //throw new Exception("Browser is not correct");
		  }
		
	    //baseUrl = "http://bdigital.ufp.pt/";
		
	   //Parametrization of implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }

	  
	  //We should create a super class class and extend in the test classes
	  @Test(dataProvider = "urls-Function")
	  public void TestExistButtonSearch(String url) throws Exception {
	    //this.url = url;
		driver.get(url + "/");
		//driver.findElement(By.linkText("Entrar:")).click();
		//driver.findElement(By.cssSelector("img.img-responsive")).click();
	    try {
	      AssertJUnit.assertTrue(isElementPresent(By.cssSelector("img.img-responsive")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	  
	  //Should be in the super class
	  //Added this to use multiple urls -> Called in test functions with @Test and the dataprovider
	  //We can have multiple data providers
	  @DataProvider(name = "urls-Function")
	  public static Iterator<Object[]> urls() {
        String[] urls = {
                "http://bdigital.ufp.pt",
                /*"https://comum.rcaap.pt",
                "http://repositorio.uac.pt",
                "http://repositorio.ipcb.pt",
                "http://repositorio.insa.pt",
                "http://repositorio.ipl.pt",
                "http://repositorio.ul.pt",
                "http://repositorio.ismai.pt",
                "http://repositorio.hospitaldebraga.pt"*/
         
        };
        return Arrays.stream(urls)
                .map(s -> new Object[]{s})
                .iterator();
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

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

/*	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
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
	  }*/
}
