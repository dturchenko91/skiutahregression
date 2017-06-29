package portfolio.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Dan on 6/27/2017.
 */
public abstract class PageBase {

    public BasicPageFunctions basicPageFunctions;

    protected WebDriver driver;

    public PageBase(Provider<BasicPageFunctions> basicFunctions, By pageIdentifier)
    {
        basicPageFunctions = basicFunctions.get();
        this.driver = basicPageFunctions.getDriver();

        basicPageFunctions.setPageIdentifier(pageIdentifier);

        new WebDriverWait(basicPageFunctions.getDriver(), 10)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(visibilityOfElementLocated(pageIdentifier));
    }
}
