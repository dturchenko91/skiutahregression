package portfolio.base.base.driverfactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by Dan on 6/26/2017.
 */
public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chService;


    @Override
    protected void start() {
        if(null==chService)
        {
            try
            {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stop() {
        if(null!=chService && chService.isRunning())
            chService.stop();
    }

    @Override
    protected void create() {
        driver = new ChromeDriver();
    }
}
