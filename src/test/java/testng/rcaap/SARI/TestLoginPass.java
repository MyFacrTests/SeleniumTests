package testng.rcaap.SARI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import common.Login;
import dataproviders.DataProviderClass;

public class TestLoginPass extends Login {

	/*private String user = null;
	private String pass = null;*/
	
	/*@Parameters( {"user","pass"})
	@BeforeTest
	  public void beforeTest(@Optional("user") String user, @Optional("pass")  String pass) {
		/*System.out.println("USER:" + user);
		System.out.println("PASS:" + pass);
		this.user = user;
		this.pass = pass;* /
		this.user = user != null ? user : System.getProperty("USER");
	    this.pass = pass != null ? pass : System.getProperty("PASS");  
	  }*/

	
	@Test(dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
	  public void testLogin(String url) throws Exception {
	    driver.get(url + "/password-login");
	    /*String user = System.getProperty("USER");
	    String pass = System.getProperty("PASS"); */ 
	    System.out.println("user: " + user + "pass: " + pass);
	    driver.findElement(By.id("tlogin_email")).sendKeys(user);
	    driver.findElement(By.id("tlogin_password")).clear();
	    driver.findElement(By.id("tlogin_password")).sendKeys(pass);
	    driver.findElement(By.name("login_submit")).click();
        /*    try {
      		assertTrue(isElementPresent(By.xpath("//main[@id='content']/div[3]/div/div")));
   	    } catch (Error e) {
      		verificationErrors.append(e.toString());
   	    }*/
    	    driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();
	  }
}
