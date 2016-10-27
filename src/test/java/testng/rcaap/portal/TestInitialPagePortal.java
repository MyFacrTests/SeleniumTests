package testng.rcaap.portal;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import dataproviders.DataProviderClass;
import static org.testng.Assert.*;
import testng.rcaap.TestBase;

//Tests to see if is is present the search box and click button
public class TestInitialPagePortal extends TestBase {

	@Test(dataProvider = "portal-url", dataProviderClass = DataProviderClass.class)
	  public void testPortalBasic(String baseUrl) throws Exception {
	    driver.get(baseUrl + "/");
	    
	    System.out.println("Runing Test - Exists Search Box");
	    
	    assertTrue(isElementPresent(By.id("txt")));
	    assertTrue(isElementPresent(By.name("pesquisar")));
	    
	    try {
	    	assertTrue(isElementPresent(By.id("txt")));
	 	    assertTrue(isElementPresent(By.name("pesquisar")));
	    } catch (Error e) {
	        //System.out.println(e.toString());
	    	verificationErrors.append(e.toString());
	    }
	  }
	
}
