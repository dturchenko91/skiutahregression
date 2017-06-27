package portfolio.base.base.driverfactory;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dan on 6/26/2017.
 */
public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void start();
    protected abstract void stop();
    protected abstract void create();

    public void quitDriver()
    {
        if(null!=driver)
        {
            driver.quit();
            driver = null;
        }
    }

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
