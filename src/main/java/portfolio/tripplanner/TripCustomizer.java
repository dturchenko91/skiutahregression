package portfolio.tripplanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.List;

/**
 * Created by Dan on 6/29/2017.
 */
public class TripCustomizer extends PageBase {

    private Provider<TripPlannerResults> resultsPage;

    @Inject
    public TripCustomizer(Provider<TripPlannerResults> resultsPage, Provider<BasicPageFunctions> basicFunctions) {
        super(basicFunctions, By.cssSelector("form.trp_choose-boxes"));

        this.resultsPage = resultsPage;
    }

    public TripCustomizer setTripCriteria(TripModel data)
    {
        return
                setResortsCriteria(data.getAmenities());
    }

    private TripCustomizer setResortsCriteria(List<ResortAmenity> data)
    {
        WebElement resortOptions = driver.findElement(By.cssSelector("div.choose_01"));

        for (ResortAmenity amenity: data)
        {
            for(WebElement button: resortOptions.findElements(By.cssSelector("label.not-really-a-btn")))
            {
                if(button.findElement(By.cssSelector("span")).getText().equals(amenity.getCustomCriteriaName()))
                {
                    button.findElement(By.cssSelector("input.trpSelect")).click();
                    break;
                }
            }
        }

        return this;
    }

    public TripPlannerResults submitSearch()
    {
        Actions builder = new Actions(driver);

        builder.moveToElement( driver.findElement(By.cssSelector("div.choose_submit>button>h4"))).click().perform();

        return resultsPage.get();
    }


}
