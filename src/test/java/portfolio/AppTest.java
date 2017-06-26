package portfolio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.base.PortfolioJunit4Runner;
import portfolio.base.WebDriverRule;

import javax.inject.Inject;

/**
 * Unit test for simple App.
 */
//@RunWith(PortfolioJunit4Runner.class)
public class AppTest
{
    @Inject
    @Rule
    public WebDriverRule webDriverRule;

    @Test
    public void shouldDisplayCorrectBrowserProperty()
    {
        System.out.println("Should display phantomjs above");
    }

}
