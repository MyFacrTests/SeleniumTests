package testng.rcaap.SARI;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import dataproviders.DataProviderClass;
import testng.rcaap.TestBase;
import org.openqa.selenium.*;

public class TestSearchPresent extends TestBase{
	  
	  //We should create a super class class and extend in the test classes
	  @Test(dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
	  public void TestExistButtonSearch(String url) throws Exception {
	    //this.url = url;
		driver.get(url + "/");
		 System.out.println("TESTE - BUTTON");
		try {
	     assertTrue(isElementPresent(By.cssSelector("button.btn.btn-primary")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
		
	  }
}
