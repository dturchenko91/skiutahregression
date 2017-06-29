package portfolio.tripplanner;

import com.google.inject.Inject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import portfolio.common.DriverRule;
import portfolio.common.PortfolioJunit4Runner;

import javax.inject.Named;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dan on 6/28/2017.
 */
@RunWith(PortfolioJunit4Runner.class)
@PortfolioJunit4Runner.GuiceModules(TripPlanModule.class)
public class TripPlanTest {
    @Inject
    @Rule
    public DriverRule driverRule;

    @Inject
    private TripPlannerNavigator navigator;

    @Inject
    @Named("FamilyTripData")
    private TripModel familyTripData;

    @Inject
    @Named("PowderhoundData")
    private TripModel powderhoundData;

    @Inject
    @Named("SkierOnlyData")
    private TripModel skierOnlyData;
    @Test
    public void shouldRemoveResortCardFromRecommendationsWhenClicked()
    {
        TripPlannerMain main = navigator.getTripPlanner();
        TripPlannerResults planner = main.getFamilyResults();

        List<TripPlannerResults.ResortCard> resorts = planner.getResorts();
        TripPlannerResults.ResortCard resort = resorts.get(0);
        resort.close();
        assertFalse(planner.resortDisplayed(resort.getName()));
    }

    @Test
    public void shouldRecommendResortsWithAppropriateAmenitiesForFamilies()
    {
        TripPlannerMain main = navigator.getTripPlanner();
        TripPlannerResults planner = main.getFamilyResults();

        assertTrue(planner.atLeastOneResortWithDesiredAmenities(familyTripData));
    }

    @Test
    public void shouldRecommendResortsWithAppropriateAmenitiesForPowderhounds()
    {
        TripPlannerMain main = navigator.getTripPlanner();
        TripPlannerResults planner = main.getPowderhoundResults();

        assertTrue(planner.atLeastOneResortWithDesiredAmenities(powderhoundData));
    }

    @Test
    public void shouldRecommendResortsByCustomSearch()
    {
        TripPlannerMain main = navigator.getTripPlanner();
        TripCustomizer customizer = main.createCustomTrip();

        TripPlannerResults planner = customizer.setTripCriteria(skierOnlyData)
                .submitSearch();

        boolean correctCardDisplayed = false;
        while(!correctCardDisplayed)
        {
            TripPlannerResults.ResortCard resort = planner.getResorts().get(0);
            if(resort.hasAmenity(skierOnlyData.getAmenities().get(0)))
            {
                correctCardDisplayed = true;
            }
            else
            {
                resort.close();
            }
        }

        assertTrue(planner.atLeastOneResortWithDesiredAmenities(skierOnlyData));
    }


}
