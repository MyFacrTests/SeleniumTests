package testng.rcaap.SARI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import common.Login;
import dataproviders.DataProviderClass;
import static org.testng.Assert.*;

public class TestMetadataSchema extends Login {

	
	@Test(dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
	public void testMetadataSchema(String baseUrl) throws Exception {
		 driver.get(baseUrl + "/password-login");
		    System.out.println("user: " + user + "pass: " + pass);
		    driver.findElement(By.id("tlogin_email")).sendKeys(user);
		    driver.findElement(By.id("tlogin_password")).clear();
		    driver.findElement(By.id("tlogin_password")).sendKeys(pass);
		    driver.findElement(By.name("login_submit")).click();
		    /*Thread.sleep(100);
		    driver.get(baseUrl + "/dspace-admin/metadata-schema-registry");*/
		    driver.findElement(By.xpath("//a[contains(text(), '" + user +"')]")).click();
		    driver.get(baseUrl + "/dspace-admin");
		    driver.findElement(By.xpath("(//a[contains(@href, '#')])[4]")).click();
		    driver.findElement(By.xpath("//a[contains(@href, '/dspace-admin/metadata-schema-registry')]")).click();
	    try {
	    	 assertTrue(isElementPresent(By.xpath("//main[@id='content']/div[3]/form/div[3]/input")));
	    	 driver.get(baseUrl + "/logout");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	   
	  }
}
