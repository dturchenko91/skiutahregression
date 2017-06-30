package portfolio.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portfolio.home.HomePage;
import portfolio.resorts.ResortsAndSnowPage;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Dan on 6/29/2017.
 */
public class BasicPageFunctions
{
    private WebDriver driver;

    private By pageIdentifier;

    private Provider<HomePage> homePage;
    private Provider<ResortsAndSnowPage> resortsAndSnowPage;

    @Inject
    public BasicPageFunctions(WebDriver driver, Provider<HomePage> homePage, Provider<ResortsAndSnowPage> resortsAndSnowPage)
    {
        this.driver = driver;
        this.homePage = homePage;
        this.resortsAndSnowPage = resortsAndSnowPage;
    }

    public void setPageIdentifier(By pageIdentifier)
    {
        this.pageIdentifier = pageIdentifier;
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

    public WebDriver getDriver()
    {
        return this.driver;
    }
}
