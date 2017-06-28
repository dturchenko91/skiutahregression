package portfolio.tripplanner;

import com.google.inject.AbstractModule;
import portfolio.common.DriverModule;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlanModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DriverModule());
    }
}
