package portfolio.base.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.inject.Inject;

/**
 * Created by Dan on 6/26/2017.
 */
public class WebdriverInitializer {

    private WebDriver driver;

    @Inject
    public WebdriverInitializer()
    {

    }

    public WebDriver driverInit()
    {
        switch(System.getProperty("browsers"))
        {
            default: return new FirefoxDriver();
            case "firefox": return new FirefoxDriver();
            case "chrome": return new ChromeDriver();
            case "phantomjs": return new PhantomJSDriver();
        }
    }
}
