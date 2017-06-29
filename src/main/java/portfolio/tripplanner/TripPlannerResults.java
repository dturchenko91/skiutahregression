package portfolio.tripplanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlannerResults extends PageBase
{
    @Inject
    public TripPlannerResults(Provider<BasicPageFunctions> basicFunctions)
    {
        super(basicFunctions, By.cssSelector("article.resorts_card"));
    }

    public List<ResortCard> getResorts()
    {
        List<ResortCard> output = new ArrayList<>();
        List<WebElement> resorts = driver.findElements(By.cssSelector("article.resorts_card"));
        for(WebElement resort: resorts)
        {
            if(resort.isDisplayed())
            {
                int index = resorts.indexOf(resort) + 1;
                output.add(new ResortCard(By.cssSelector("article.resorts_card:nth-child(" + index + ")")));
            }
        }

        return output;
    }

    public Boolean resortDisplayed(String name)
    {
        for (ResortCard card: getResorts())
        {
            if(card.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public boolean atLeastOneResortWithDesiredAmenities(TripModel data)
    {
        for(ResortCard resort: getResorts())
        {
            boolean hasAllAmenities = true;
            for(ResortAmenity amenity: data.getAmenities())
            {
                if(!resort.hasAmenity(amenity))
                {
                    hasAllAmenities = false;
                }
            }
            if(hasAllAmenities)
                return true;
        }
        return false;
    }

    public class ResortCard
    {
        private By cardContainer;
        private String name;
        private List<String> amenities;

        public ResortCard(By cardContainer)
        {
            this.cardContainer = cardContainer;

            this.name = getContainerElement().findElement(By.cssSelector("h2")).getText();

            List<String> amenities = new ArrayList<>();

            for(WebElement amenity: getContainerElement().findElements(By.cssSelector("li.checkmark")))
            {
                amenities.add(amenity.getText());
            }

            this.amenities = amenities;
        }

        private WebElement getContainerElement()
        {
            return driver.findElement(cardContainer);
        }

        public String getName()
        {
            return this.name;
        }

        public List<String> getAmenities()
        {
            return this.amenities;
        }

        public void close()
        {
            WebElement closeButton = getContainerElement().findElement(By.cssSelector("a.remove-resort-link>div"));
            closeButton.click();

            new WebDriverWait(driver, 5)
                    .pollingEvery(100, TimeUnit.MILLISECONDS)
                    .until(invisibilityOf(closeButton));
        }

        public boolean hasAmenity(ResortAmenity amenity)
        {
            for(String availableAmenity: getAmenities())
            {
                if(availableAmenity.equals(amenity.getResultsName()))
                {
                    return true;
                }
            }

            return false;
        }
    }
}
