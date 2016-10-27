package testng.rcaap.SARI;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dataproviders.DataProviderClass;
import testng.rcaap.TestBase;

//@Test(groups = "scripts")
public class TestExternalScriptsPresent extends TestBase{

  @Test(dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
  public void testGA(String baseUrl) throws Exception {
	  driver.get(baseUrl + "/");
    assertTrue(isElementPresent(By.xpath("//script[@type='text/javascript'][contains(text(), 'UA-')]")));
  }
  
  @Test(dataProvider = "urls-all", dataProviderClass = DataProviderClass.class)
  public void testPiwik(String baseUrl) throws Exception {
	  driver.get(baseUrl + "/");
    assertTrue(isElementPresent(By.xpath("//script[@type='text/javascript'][contains(text(), 'piwik')]")));
  }
  
@Test(groups = "scripts", dataProvider = "plumx", dataProviderClass = DataProviderClass.class)
  public void testPlumX(String baseUrl, String prefix, String handle) throws Exception {
    
	/*System.out.println("baseUrl " + baseUrl );
	System.out.println("prefix " + prefix );
	System.out.println("handle " + handle );*/
      driver.get(baseUrl + "/handle/" + prefix +"/" + handle);
      assertTrue(isElementPresent(By.xpath("//div[@class='PlumX-Popup']")));
  }

}
