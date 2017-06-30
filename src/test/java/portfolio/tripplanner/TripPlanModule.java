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
        List<ResortAmenity> amenities = new ArrayList<>();
        amenities.add(ResortAmenity.SKISCHOOL);
        amenities.add(ResortAmenity.EQUIPMENTRENTAL);
        amenities.add(ResortAmenity.DAYCARE);

        return new TripModel(amenities);
    }

    @Provides
    @Named("PowderhoundData")
    public TripModel powderhoundData()
    {
        List<ResortAmenity> amenities = new ArrayList<>();
        amenities.add(ResortAmenity.ONMOUNTAINBAR);
        return new TripModel(amenities);
    }

    @Provides
    @Named("SkierOnlyData")
    public TripModel skierOnlyData()
    {
        List<ResortAmenity> amenities = new ArrayList<>();
        amenities.add(ResortAmenity.SKIERSONLY);
        return new TripModel(amenities);
    }
}
