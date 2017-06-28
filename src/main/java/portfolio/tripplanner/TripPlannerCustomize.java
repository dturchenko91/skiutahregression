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
public class TripPlannerCustomize extends PageBase
{
    @Inject
    public TripPlannerCustomize(WebDriver driver, Provider<HomePage> homePage, Provider<ResortsAndSnowPage> resortsAndSnowPage, By pageIdentifier)
    {
        super(driver, homePage, resortsAndSnowPage, By.cssSelector("a#clearChkboxes"));
    }
}
