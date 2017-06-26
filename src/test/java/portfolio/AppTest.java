package portfolio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.base.DependencyInjectionTest;
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

    @Inject
    private DependencyInjectionTest dependencyInjectionTest;

    @Test
    public void shouldDisplayCorrectBrowserProperty()
    {
        System.out.println("Should display phantomjs above");
    }

    @Test
    public void shouldDisplayDependencyInjectionTestString()
    {
        System.out.println(dependencyInjectionTest.getTestString());
    }

}
