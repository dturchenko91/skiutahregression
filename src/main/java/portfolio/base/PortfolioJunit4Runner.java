package portfolio.base;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

/**
 * Created by Dan on 6/26/2017.
 */
public class PortfolioJunit4Runner extends Runner {

    public PortfolioJunit4Runner(Class testClass){}
    public Description getDescription() {
        return null;
    }

    public void run(RunNotifier runNotifier) {
        System.out.println("Custom runner now running");
    }
}
