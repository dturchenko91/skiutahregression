package portfolio.base;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

/**
 * Created by Dan on 6/26/2017.
 */
public class BaseModule extends AbstractModule {

    //public BaseModule(){}

    protected void configure() {

    }

    @Provides
    @Named("dependencyInjectionTest")
    public String dependencyInjectionTest()
    {
        return "injected";
    }
}
