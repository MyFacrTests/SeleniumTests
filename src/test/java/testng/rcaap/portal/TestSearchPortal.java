package testng.rcaap.portal;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import dataproviders.DataProviderClass;
import static org.testng.Assert.*;
import testng.rcaap.TestBase;

//Tests to see if is is present the search box and click button
public class TestSearchPortal extends TestBase {

	@Test(dataProvider = "portal-url", dataProviderClass = DataProviderClass.class)
	public void testProcurarPortal(String baseUrl) throws Exception {
		System.out.println("Runing Test - Search String: " + baseUrl);
		
		driver.get(baseUrl);
	    driver.findElement(By.id("txt")).clear();
	    driver.findElement(By.id("txt")).sendKeys("psicologia");
	    driver.findElement(By.name("pesquisar")).click();
	    
	    try {
	    	assertTrue(isElementPresent(By.name("search")));
	    	assertTrue(isElementPresent(By.cssSelector("div.pagNavBox")));
	    } catch (Error e) {
	        //System.out.println(e.toString());
	    	verificationErrors.append(e.toString());
	    }
	  }
}
