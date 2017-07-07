package portfolio.search;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import portfolio.common.DriverModule;

import javax.inject.Named;

/**
 * Created by Dan on 7/4/2017.
 */
public class SearchModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new DriverModule());
    }

    @Provides
    @Named("snowbird")
    public String getSearchCriteria(){return "snowbird";}
}
