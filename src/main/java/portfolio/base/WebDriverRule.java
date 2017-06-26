package portfolio.base;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import javax.inject.Inject;

/**
 * Created by Dan on 6/26/2017.
 */
public class WebDriverRule implements TestRule {

    public Statement apply(final Statement base, Description description) {
        return new driverRuleStatement(base);
        };

    public class driverRuleStatement extends Statement{

        private final Statement base;

        public driverRuleStatement(Statement base) {
            this.base = base;
        }

        public void evaluate() throws Throwable {
            System.out.println(System.getProperty("browsers"));
            base.evaluate();
        }
    }

}






