package dataproviders;

import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

/*
 * Inject this values with Spring??????
 */

public class DataProviderClass {
	
	 //Should be in the super class
	  //Added this to use multiple urls -> Called in test functions with @Test and the dataprovider
	  //We can have multiple data providers
	  @DataProvider(name = "urls-all")
	  public static Iterator<Object[]> urls() {
      String[] urls = {
              "http://bdigital.ufp.pt",
              "https://comum.rcaap.pt",
              "http://repositorio.uac.pt",
              "http://repositorio.ipcb.pt",
              "http://repositorio.insa.pt",
              "http://repositorio.ipl.pt",
              "http://repositorio.ul.pt",
              "http://repositorio.ismai.pt",
              "http://repositorio.hospitaldebraga.pt",
              "http://repositorio.ucp.pt",
              "http://sapientia.ualg.pt",
              "http://ubibliorum.ubi.pt",
              "http://run.unl.pt",
              "http://www.repository.utl.pt",
              "http://arca.igc.gulbenkian.pt",
              "http://repositorio.ispa.pt",
              "http://bibliotecadigital.ipb.pt",
              "http://iconline.ipleiria.pt",
              "http://digituma.uma.pt",
              "http://repositorioaberto.uab.pt",
              "http://rihuc.huc.min-saude.pt",
              "http://repositorio.chporto.pt",
              "http://repositorio.chlc.min-saude.pt",
              "http://repositorio.hff.min-saude.pt",
              "http://recipp.ipp.pt",
              "http://repositorio.ipsantarem.pt",
              "http://repositorio.ipv.pt",
              "http://repositorio.lneg.pt"
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  /*
	   * URL for SARIS with PLUMX
	   * We must have na handle to specify the test, bcause plumx tests need an item
	   */
	  @DataProvider(name = "plumx-handle")
	  public static Object[][] urlsPlumXHandle() {
		  return new String[][] {
			  {"http://rihuc.huc.min-saude.pt", "10400.4"},
    		};
	  }
	  
	  /*
	   * SARI - URL with LDAP
	   */
	  @DataProvider(name = "plumx")
	  public static Iterator<Object[]> plumx() {
      String[] urls = {
    		  "http://rihuc.huc.min-saude.pt"
       
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  /*
	   * SARI - URL with LDAP
	   */
	  @DataProvider(name = "urls-ldap")
	  public static Iterator<Object[]> urlsLDAP() {
      String[] urls = {
              "http://bdigital.ufp.pt",
              "http://bibliotecadigital.ipb.pt"
       
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  // PRE
	  @DataProvider(name = "urls-all-pre")
	  public static Iterator<Object[]> urlsPRE() {
      String[] urls = {
              "http://bdigital-ufp.pre.rcaap.pt",
              /*"https://comum-rcaap.pre.rcaap.pt",
              "http://repositorio-uac.pre.rcaap.pt",
              "http://repositorio-ipcb.pre.rcaap.pt",
              "http://repositorio-insa.pre.rcaap.pt",
              "http://repositorio-ipl.pre.rcaap.pt",
              "http://repositorio-ul.pre.rcaap.pt",
              "http://repositorio-ismai.pre.rcaap.pt",
              "http://repositorio-hospitaldebraga.pre.rcaap.pt"*/
       
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  
	  
	  
	  /*
	   * 
	   * 
	   * PORTAL
	   * 
	   */
	  
	  @DataProvider(name = "portal-url")
	  public static Iterator<Object[]> urlsPortal() {
      String[] urls = {
              "http://www.rcaap.pt",
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  /*
	   * 
	   * 
	   * Validator
	   * 
	   */
	  
	  @DataProvider(name = "validators-url")
	  public static Iterator<Object[]> urlsValidator() {
      String[] urls = {
              "http://validator.rcaap.pt",
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	  
	  @DataProvider(name = "cpre")
	  public static Iterator<Object[]> cpre() {
      String[] urls = {
    		  "http://comum-rcaap.pre.rcaap.pt"
       
      };
      return Arrays.stream(urls)
              .map(s -> new Object[]{s})
              .iterator();
	  }
	   
}
