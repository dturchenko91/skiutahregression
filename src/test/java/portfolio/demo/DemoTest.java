package portfolio.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.base.base.PortfolioJunit4Runner;
import portfolio.base.base.WebDriverRule;

import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for simple App.
 */
@RunWith(PortfolioJunit4Runner.class)
@PortfolioJunit4Runner.GuiceModules(DemoModule.class)
public class DemoTest
{
    @Inject
    public WebDriverRule webDriverRule;

    @Inject
    @Named("dependencyInjectionTest")
    private String dependencyInjectionTest;

    @Test
    public void shouldDisplayDependencyInjectionTestString()
    {
        assertThat(dependencyInjectionTest, is("injected"));
    }

}
