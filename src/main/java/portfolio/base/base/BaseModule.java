package portfolio.base.base;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.inject.Named;

/**
 * Created by Dan on 6/26/2017.
 */
public class BaseModule extends AbstractModule {

    @Override
    protected void configure()
    {

    }

    @Provides
    @Named("dependencyInjectionTest")
    public String dependencyInjectionTest()
    {
        return "injected";
    }


}
