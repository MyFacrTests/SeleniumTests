Test Suits:

- For each individual Service We will have tests suits where tests are defined.
- Presently we have for SARI, Portal and Validator
- These suits are called from maven.  
- Test suits can call other test suits


Exeample of a testsuit and explanations:

- Format XML
- The parallel="classes" and thread-count=3 means the classes will be run in parallel with 3 simultaneously. If these parameteres are defined in maven than it will run wit that configurations: 
  - In maven:
    		<configuration>
		        ....
   - If methods are defined than the methods run in parallel (See tsetng documentation)
   
-Each test has a name, we defined that the names of tests are for the browser instances
  - We pass a parameter, ex: <parameter name="browser" value="chrome" />, that will run the chrome driver. To enable this in java class we have to have @Parameters({"browser",...})
and in the setUp(String browser, ...).
  - This parameter can also be passed with maven.
  - We can have all the parameters we want.
  
- We can include/exclude groups that will run the tests (see testng documentation for groups)
  Example: if we want one test to belong to a group and only run the tests in that group.
  In Java Test classes we have to pass @Test(groups = {"group1", "group2", ...} 
  
Instead of groups we use the beanshell to pass parameters from maven and then run only tests that have been passed from maven -DgroupsToRun=group1,group2,....
  -If we want to run only the headless test we add -DgroupsToRun=headless, 
  - To run with chrome and headless -DgroupsToRun=headless,chrome
  - To run all browsers -DgroupsToRun=all

- Each test we want to run must be added in the <class name="testng.rcaap.validator.TestValidation"/>



<?xml version="1.0" encoding="UTF-8"?>
<!-- Threading count to execute paralel tests and parallel set to tests (classes see documentation) -->
<!-- I think if We have 2 classes they will run in parallel -->
<suite name="ValidatorTest" parallel="classes" thread-count="3"> 

  <test name="TestNgValidatorChrome">
  <!-- These groups are defined in the maven and in the Test Files -->
   <method-selectors>
	  <method-selector>
	    <script language="beanshell"><![CDATA[
	       String grps = System.getProperty("groupsToRun");
	       return grps.contains("firefox") || grps.contains("all");
	     ]]></script>
	  </method-selector>
</method-selectors>
  <parameter name="browser" value="chrome" />
   

  <test name="TestNgValidatorFirefox">
  <!-- These groups are defined in the maven and in the Test Files -->
   <method-selectors>
	  <method-selector>
	    <script language="beanshell"><![CDATA[
	       String grps = System.getProperty("groupsToRun");
	       return grps.contains("firefox") || grps.contains("all");
	     ]]></script>
	  </method-selector>
</method-selectors>
  <parameter name="browser" value="firefox" />
    <classes>
        <class name="testng.rcaap.validator.TestValidation"/>
    </classes>
  </test>
 
  <test name="TestNgValidatorHeadless">
  <!-- These groups are defined in the maven and in the Test Files -->
   <method-selectors>
	  <method-selector>
	    <script language="beanshell"><![CDATA[
	       String grps = System.getProperty("groupsToRun");
	       return grps.contains("headless") || grps.contains("all");
	     ]]></script>
	  </method-selector>
</method-selectors>
  <parameter name="browser" value="headless" />
    <classes>
       <class name="testng.rcaap.validator.TestValidation"/> 
    </classes>
  </test>
</suite>


---- MAVEN
Maven can pass the following argumets
<user>${env.USER}</user>
    <pass>${env.PASS}</pass>    
    <!-- <pass>${env.OS}</pass> -->                
</systemPropertyVariables>
<suiteXmlFiles>
    <!-- <suiteXmlFile>testng.xml</suiteXmlFile>-->
    <suiteXmlFile>${suitefilename}</suiteXmlFile>
</suiteXmlFiles>
<groups>${browserToRun}</groups>

-Dsuitefilename=pathToSuit
-DbrowserToRun=BrowserToRun
-DUSER - Authentication (Will be a Jenkins parameter)
-DPASS - Authentication (Will be a Jenkins parameter)
-Dos - Wich OS environment the tests will be RUN (Jenkins parameter)
  - windows or linux, defaults to linux
 
BrowserTorRun is passed to sutie.xml and overlaps groups.

  
These parameters user, os and pass should be dependet injected in test classes
User and Pass in the BeforeTest
@Parameters( {"user","pass"})
	@BeforeTest
	  public void beforeTest(@Optional("user") String user, @Optional("pass")  String pass)
	  
And must be marked also as @Optional in case these parameters doesn't exists in the arguments.
They can also be added in the suitfile.

-the os parameter is also needed in the setUp
@Parameters({"browser", "os"})// this annotation is used to insert browser parameter from TestNG 
	@BeforeClass(alwaysRun = true)
    public void setUp(String browser, @Optional("windows") String os) throws Exception {
    
    
-Test classes
The tests must be defined in Selenium and than exported toTestNg and converted here to follow the structure of our test framework. See tests already defined as examples. This section is still in development




----- The files wihtou beanshell run all tests but browser should be specified in maven
      We can add a group to run in maven but it must exist in test
      mvn -Dgroups=t1,t2 must be set in @Test(groups={"t1"} if we want specific groups to run