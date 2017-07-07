package portfolio.common;

import com.google.inject.Inject;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Dan on 6/30/2017.
 */
public class DriverRuleChain implements TestRule {

    TestRule chain;

    @Inject
    public DriverRuleChain(DriverRule driverRule, RetryRule retryRule, ScreenshotRule screenshotRule)
    {
        chain = RuleChain.outerRule(driverRule)
                .around(retryRule)
                .around(screenshotRule);
    }
    @Override
    public Statement apply(Statement statement, Description description) {
        return chain.apply(statement, description);
    }
}
