package portfolio.tripplanner;

import org.openqa.selenium.WebDriver;
import portfolio.common.UrlBuilder;

import javax.inject.Inject;
import javax.inject.Provider;
import java.net.URL;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlannerNavigator {
    private WebDriver driver;
    private UrlBuilder urlBuilder;
    private Provider<TripPlannerMain> tripPlanner;

    @Inject
    public TripPlannerNavigator(WebDriver driver, UrlBuilder urlBuilder, Provider<TripPlannerMain> tripPlanner)
    {
        this.driver = driver;
        this.urlBuilder = urlBuilder;
        this.tripPlanner = tripPlanner;
    }

    public TripPlannerMain getTripPlanner()
    {
        urlBuilder.replacePath("trip-planner");
        driver.get(urlBuilder.build());

        return tripPlanner.get();
    }
}
