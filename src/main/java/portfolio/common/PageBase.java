package portfolio.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portfolio.home.HomePage;
import portfolio.resorts.ResortsAndSnowPage;

import javax.inject.Provider;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Dan on 6/27/2017.
 */
public abstract class PageBase {

    protected WebDriver driver;

    protected By pageIdentifier;

    protected Provider<HomePage> homePage;
    protected Provider<ResortsAndSnowPage> resortsAndSnowPage;

    public PageBase(WebDriver driver, Provider<HomePage> homePage, Provider<ResortsAndSnowPage> resortsAndSnowPage, By pageIdentifier)
    {
        this.driver = driver;
        this.homePage = homePage;
        this.resortsAndSnowPage = resortsAndSnowPage;
        this.pageIdentifier = pageIdentifier;

        new WebDriverWait(driver, 5)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(visibilityOfElementLocated(pageIdentifier));
    }

    public Boolean isDisplayed()
    {
        return driver.findElement(pageIdentifier).isDisplayed();
    }

    public HomePage getHomePage()
    {
        driver.findElement(By.cssSelector("img.HeaderMain-logoImg")).click();

        return homePage.get();
    }

    public ResortsAndSnowPage getResortsAndSnowPage()
    {
        Actions builder = new Actions(driver);

        builder.click(driver.findElement(By.cssSelector("a[title='Resorts & Snow']"))).click(driver.findElement(By.cssSelector("a[title='Resorts & Snow']"))).perform();

        return resortsAndSnowPage.get();
    }
}
