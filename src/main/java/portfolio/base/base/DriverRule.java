package portfolio.base.base;

import com.google.inject.Inject;
import com.google.inject.Provides;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import portfolio.base.base.driverfactory.DriverFactory;

/**
 * Created by Dan on 6/27/2017.
 */
public class DriverRule implements TestRule {

    private DriverFactory factory;
    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable
            {
                base.evaluate();
                factory.quit();
            }
        };
    }

    @Inject
    public void getFactory(DriverFactory factory)
    {
        this.factory = factory;
    }


}
