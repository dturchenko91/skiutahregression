package portfolio.common.driverfactory;

import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dan on 6/27/2017.
 */
public abstract class DriverFactory {

    protected WebDriver driver;

    protected abstract void start();

    protected abstract void stop();

    protected abstract void create();

    public void quit()
    {
        if(null!=driver)
        {
            driver.quit();
            driver = null;
        }
    }

    @Provides
    public WebDriver getDriver()
    {
        if(null==driver)
        {
            start();
            create();
        }

        return driver;
    }

}
