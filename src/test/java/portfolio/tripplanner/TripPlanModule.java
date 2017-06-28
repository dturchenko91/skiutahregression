package portfolio.tripplanner;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import portfolio.common.DriverModule;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlanModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DriverModule());
    }

    @Provides
    @Named("FamilyTripData")
    public TripModel familyTripModel()
    {
        List<String> amenities = new ArrayList<>();
        amenities.add("Ski School");
        amenities.add("Equipment Rental");
        amenities.add("Day Care");

        return new TripModel(amenities);
    }
}
