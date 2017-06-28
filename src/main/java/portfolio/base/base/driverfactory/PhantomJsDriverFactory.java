package portfolio.base.base.driverfactory;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by Dan on 6/27/2017.
 */
public class PhantomJsDriverFactory extends DriverFactory {
    @Override
    protected void start() {
        PhantomJsDriverManager.getInstance().setup();
    }

    @Override
    protected void stop() {

    }

    @Override
    protected void create() {
        driver = new PhantomJSDriver();
    }
}
