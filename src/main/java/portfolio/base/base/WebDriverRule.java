package portfolio.base.base;

import com.google.inject.Provides;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Dan on 6/26/2017.
 */
public class WebDriverRule implements TestRule {

    public Statement apply(final Statement base, Description description)
    {
        return new driverInitialization(base);
    }

    public class driverInitialization extends Statement{

        @Inject
        @Named("webdriver-init")
        private WebDriver driver;

        private final Statement base;

        public driverInitialization(Statement base)
        {
            this.base = base;
            driverInit();
        }

        public void evaluate() throws Throwable {

            base.evaluate();
        }

        @Provides
        private WebDriver driverInit()
        {
            driver.manage().window().maximize();
            return driver;
        }
    }

}






