package ScriptHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver(ITestContext ctx) throws MalformedURLException {
        //BROWSER=> chrome/firefox
        //HUB_HOST=>localhost/10.1.1.3/ hostname

        String host="localhost";
        DesiredCapabilities cap;
        if(System.getProperty("BROWSER")!=null && (System.getProperty("BROWSER").equalsIgnoreCase("firefox")))
        {
            cap=DesiredCapabilities.firefox();
        }else{
            cap=DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST")!=null){
            host=System.getProperty("HUB_HOST");
        }
        String testname=ctx.getCurrentXmlTest().getName();
        String completeURL="http://"+host+":4444/wd/hub";
        cap.setCapability("name", testname);
        this.driver=new RemoteWebDriver(new URL(completeURL), cap);
    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}

