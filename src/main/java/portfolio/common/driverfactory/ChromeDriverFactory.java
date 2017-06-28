package portfolio.common.driverfactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Dan on 6/27/2017.
 */
public class ChromeDriverFactory extends DriverFactory {
    @Override
    protected void start() {
        ChromeDriverManager.getInstance().setup();
    }

    @Override
    protected void stop() {

    }

    @Override
    protected void create() {
        driver = new ChromeDriver();
    }
}
