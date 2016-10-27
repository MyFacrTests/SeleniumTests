package testng.rcaap.portal;

import static org.testng.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.Login;
import dataproviders.DataProviderClass;

//Tests to see if is is present the search box and click button
public class TestLoginAdmin extends Login {

	/*private String user = null;
	private String pass = null;*/
	
/*	@Parameters( {"user","pass"})
	@BeforeTest
  public void beforeTest(@Optional("user") String user, @Optional("pass")  String pass) {
	/*System.out.println("USER:" + user);
	System.out.println("PASS:" + pass);
	this.user = user;
	this.pass = pass;* /
	this.user = user != null ? user : System.getProperty("USER");
    this.pass = pass != null ? pass : System.getProperty("PASS");  
  }*/
	
	@Test(dataProvider = "portal-url", dataProviderClass = DataProviderClass.class)
	public void testProcurarPortal(String baseUrl) throws Exception {
		System.out.println("Runing Test - Login Admin");

		//Need to change symbol
		String url = "https://" + user + ":" + pass + "@" + baseUrl.replace("http://www.", "");
		System.out.println("Runing Test -  " + url + "/admin/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get(url + "/admin/");
		//driver.get("https://USER:PASS@www.rcaap.pt/admin/");
		
		//Dumb thing to bypass firefox alert...
		try{
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		 	String alertText = alert.getText();
			System.out.println("Alert text is " + alertText);
			alert.accept();
		}catch(TimeoutException te){
			System.out.println("Firefox Alert Bypass");
		}
		catch(NoAlertPresentException nae){
			System.out.println("Firefox Alert Bypass");
		}
		//Needs to be here
		Thread.sleep(5000);
		driver.findElement(By.linkText("Adicionar")).click();
		driver.findElement(By.name("id")).clear();
	    driver.findElement(By.name("id")).sendKeys("arca");
	    driver.findElement(By.name("url")).clear();
	    driver.findElement(By.name("url")).sendKeys("http://arca.igc.gulbenkian.pt");
	    //Thread.sleep(3000);
		
	    try {
	    	assertTrue(isElementPresent(By.cssSelector("input[type=\"submit\"]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }

	  }
}
