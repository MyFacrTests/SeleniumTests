package testng.rcaap.validator;

import org.testng.annotations.Test;
import dataproviders.DataProviderClass;
import testng.rcaap.TestBase;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class TestValidation extends TestBase {

	 @Test(dataProvider = "validators-url", dataProviderClass = DataProviderClass.class)
	 public void TestValidator(String baseUrl) throws Exception {
	    driver.get(baseUrl + "/validator2/?locale=en");
	    System.out.println("URL" + baseUrl + "?locale=en");
	    driver.findElement(By.linkText("Validate now")).click();
	    driver.findElement(By.id("resource")).clear();
	    driver.findElement(By.id("resource")).sendKeys("arca");
	    driver.findElement(By.id("url")).clear();
	    driver.findElement(By.id("url")).sendKeys("http://arca.igc.gulbenkian.pt");
	    driver.findElement(By.id("oai")).clear();
	    driver.findElement(By.id("oai")).sendKeys("http://arca.igc.gulbenkian.pt/oai/request");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("teste@teste.cor");
	    driver.findElement(By.cssSelector("div.starter-template > button.btn.btn-default")).click();
	    //Thread.sleep(3000);
	    driver.findElement(By.id("optionsRadios2")).click();
	    driver.findElement(By.id("profile_fct")).click();
	    //Thread.sleep(3000);

	    try {
	      assertTrue(isElementPresent(By.xpath("(//button[@name='submit'])[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	   
	 }	 
}
