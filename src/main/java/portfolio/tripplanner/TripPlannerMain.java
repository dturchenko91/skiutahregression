package portfolio.tripplanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import portfolio.common.PageBase;
import portfolio.home.HomePage;
import portfolio.resorts.ResortsAndSnowPage;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlannerMain extends PageBase
{
    private Provider<TripPlannerResults> results;
    @Inject
    public TripPlannerMain(WebDriver driver, Provider<HomePage> homePage, Provider<ResortsAndSnowPage> resortsAndSnowPage, Provider<TripPlannerResults> results)
    {
        super(driver, homePage, resortsAndSnowPage, By.cssSelector("a.adventure-card"));

        this.results = results;
    }

    public TripPlannerResults getFamilyResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-family']")).click();

        return results.get();
    }

    public TripPlannerResults getCouplesResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-couples']")).click();

        return results.get();
    }

    public TripPlannerResults getPowderhoundResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-powderhound']")).click();

        return results.get();
    }


}
