package portfolio.common.driverfactory;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dan on 6/27/2017.
 */
public class FirefoxDriverFactory extends DriverFactory {
    @Override
    protected void start() {
        FirefoxDriverManager.getInstance().setup();
    }

    @Override
    protected void stop() {

    }

    @Override
    protected void create() {
        driver = new FirefoxDriver();
    }
}
