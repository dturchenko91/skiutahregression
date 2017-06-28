package portfolio.base.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dan on 6/26/2017.
 */
public class HomePage {
    private WebDriver driver;

    @Inject
    public HomePage(WebDriver driver)
    {
        this.driver = driver;

        new WebDriverWait(driver, 5)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(textToBePresentInElementLocated(By.cssSelector("h1.map-Container-menuTitle"), "EXPLORE UTAH"));
    }

    public boolean isDisplayed()
    {
        return driver.findElement(By.cssSelector("h1.map-Container-menuTitle>span")).getText().equals("EXPLORE UTAH");
    }
}
