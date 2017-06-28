package portfolio.demo;

import com.google.inject.AbstractModule;
import portfolio.common.DriverModule;

/**
 * Created by Dan on 6/26/2017.
 */
public class DemoModule extends AbstractModule {
    protected void configure() {
        install(new DriverModule());
    }
}
