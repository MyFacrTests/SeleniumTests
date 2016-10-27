package common;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import testng.rcaap.TestBase;

public class Login extends TestBase {

	protected String user = null;
	protected String pass = null;
	
	@Parameters( {"user","pass"})
	@BeforeTest
	  public void beforeTest(@Optional("user") String user, @Optional("pass")  String pass) {
		/*System.out.println("USER:" + user);
		System.out.println("PASS:" + pass);
		this.user = user;
		this.pass = pass;*/
		this.user = user != null ? user : System.getProperty("USER");
	    this.pass = pass != null ? pass : System.getProperty("PASS");  
	  }
}
