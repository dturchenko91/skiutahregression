package portfolio;

import com.google.inject.AbstractModule;
import portfolio.base.BaseModule;

/**
 * Created by Dan on 6/26/2017.
 */
public class DemoModule extends AbstractModule {
    protected void configure() {
        install(new BaseModule());
    }
}
