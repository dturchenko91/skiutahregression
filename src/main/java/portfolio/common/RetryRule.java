package portfolio.common;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Dan on 6/30/2017.
 */
public class RetryRule implements TestRule {

    private int retryCount;

    public RetryRule()
    {
        this.retryCount = 3;
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;

                for(int i = 0; i < retryCount; i ++)
                {
                    try {
                        base.evaluate();
                        return;
                    }
                    catch (Throwable t)
                    {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": run " + (i+1) + " failed");
                    }
                }
                System.err.println(description.getDisplayName() + ": giving up after " + retryCount + " attempts.");
                throw caughtThrowable;
            }
        };
    }
}
