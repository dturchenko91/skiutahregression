package portfolio.base.base;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import portfolio.base.base.driverfactory.ChromeDriverManager;
import portfolio.base.base.driverfactory.DriverManager;
import portfolio.base.base.driverfactory.DriverType;

import javax.inject.Named;

/**
 * Created by Dan on 6/26/2017.
 */
public class BaseModule extends AbstractModule {

    @Override
    protected void configure()
    {
        switch (System.getProperty("browsers"))
        {
            case "chrome": bind(DriverManager.class).to(ChromeDriverManager.class).in(Scopes.SINGLETON);
                break;
            case "firefox": bind(DriverManager.class).to(Firef)
        }
    }

    @Provides
    @Named("dependencyInjectionTest")
    public String dependencyInjectionTest()
    {
        return "injected";
    }


}
