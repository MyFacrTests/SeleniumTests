package testng.rcaap;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;

public class CustomHTMLDriver extends HtmlUnitDriver {

 public CustomHTMLDriver() {}

 @Override
    protected WebClient modifyWebClient(WebClient client) {
        WebClient modifiedClient = super.modifyWebClient(client);
        modifiedClient.getOptions().setThrowExceptionOnScriptError(false); // see here
        return modifiedClient;
    }

}
