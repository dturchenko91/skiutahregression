package portfolio.home;

import com.google.inject.AbstractModule;
import portfolio.base.base.DriverModule;

/**
 * Created by Dan on 6/26/2017.
 */
public class HomeModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DriverModule());
    }
}
