package portfolio.common.driverfactory;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Dan on 7/7/2017.
 */
public class HeadlessChromeDriverFactory extends DriverFactory {
    private String path;
    private String version;
    @Override
    protected void start() {
        BrowserManager manager = ChromeDriverManager.getInstance();
        manager.setup();
        path = manager.getBinaryPath();
        version = manager.getDownloadedVersion();
    }

    @Override
    protected void stop() {

    }

    @Override
    protected void create() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(path);
        options.addArguments("--headless");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(caps);
    }
}
