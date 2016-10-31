package testng.rcaap.SARI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import common.Login;
import dataproviders.DataProviderClass;
import static org.testng.Assert.*;

public class TestMenuAdminPresent extends Login {

	

	@Test(priority = 1, dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testExecuteLogin(String baseUrl) throws Exception {
		driver.get(baseUrl + "/password-login");
		    //System.out.println("user: " + user + "pass: " + pass);
		    driver.findElement(By.id("tlogin_email")).sendKeys(user);
		    driver.findElement(By.id("tlogin_password")).clear();
		    driver.findElement(By.id("tlogin_password")).sendKeys(pass);
		    driver.findElement(By.name("login_submit")).click();
		    Thread.sleep(100);
		    driver.findElement(By.xpath("(//a[contains(@href, '#')])[5]")).click();
		    //Need this because of ldap possibilty login in some SARIs
		    driver.findElement(By.xpath("//a[contains(@href, '/dspace-admin')]")).click();
	}
	
	/**
	 * 
	 * @param baseUrl
	 * @throws Exception
	 */
	
	@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenuAdmin(String baseUrl) throws Exception {	
		 try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '/')])[2]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[2]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[3]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("//a[contains(@href, '/stats')]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[4]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[5]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }

	/*@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-ldap", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenu2(String baseUrl) throws Exception {	
		 try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[2]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }
	@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-ldap", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenu3(String baseUrl) throws Exception {	
		try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[3]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }
	@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-ldap", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenu4(String baseUrl) throws Exception {	
		 try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '/')])[2]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }
	@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-ldap", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenu5(String baseUrl) throws Exception {	
		try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[4]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }
	@Test(dependsOnMethods="testExecuteLogin", dataProvider = "urls-ldap", dataProviderClass = DataProviderClass.class)
	//@Test()
	public void testMenu6(String baseUrl) throws Exception {	
		 try {
		      assertTrue(isElementPresent(By.xpath("(//a[contains(@href, '#')])[5]")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }*/
}
