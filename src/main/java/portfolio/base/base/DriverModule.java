package portfolio.base.base;

import com.google.common.io.Closeables;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import portfolio.base.base.driverfactory.ChromeDriverFactory;
import portfolio.base.base.driverfactory.DriverFactory;
import portfolio.base.base.driverfactory.FirefoxDriverFactory;
import portfolio.base.base.driverfactory.PhantomJsDriverFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Dan on 6/26/2017.
 */
public class DriverModule extends AbstractModule {

    @Override
    protected void configure()
    {
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
