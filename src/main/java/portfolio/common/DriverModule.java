package portfolio.common;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import portfolio.common.driverfactory.ChromeDriverFactory;
import portfolio.common.driverfactory.DriverFactory;
import portfolio.common.driverfactory.FirefoxDriverFactory;
import portfolio.common.driverfactory.PhantomJsDriverFactory;

import javax.inject.Named;

/**
 * Created by Dan on 6/26/2017.
 */
public class DriverModule extends AbstractModule {

    @Override
    protected void configure()
    {
        //this is what defines what kind of webdriver to create
        //the driver factories are a wrapper for bonigarcia's driver manager project
        //the driver manager that exists within the driver factory automatically downloads and installs driver binaries before tests are run

        //the bound webdriverfactory is then injected into the method to provide the webdriver itself
        switch (System.getProperty("browsers"))
        {
            default:
                bind(DriverFactory.class).to(PhantomJsDriverFactory.class).in(Scopes.SINGLETON);
                break;
            case "chrome":
                bind(DriverFactory.class).to(ChromeDriverFactory.class).in(Scopes.SINGLETON);
                break;
            case "firefox":
                bind(DriverFactory.class).to(FirefoxDriverFactory.class).in(Scopes.SINGLETON);
                break;
        }
    }

    @Provides
    @Named("dependencyInjectionTest")
    public String dependencyInjectionTest()
    {
        return "injected";
    }

    @Provides
    public WebDriver getDriver(DriverFactory factory)
    {
        WebDriver driver = factory.getDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
