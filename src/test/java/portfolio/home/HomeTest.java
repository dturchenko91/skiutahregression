package portfolio.home;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.base.base.DriverRule;
import portfolio.base.base.PortfolioJunit4Runner;
import portfolio.base.home.HomeNavigator;
import portfolio.base.home.HomePage;

import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dan on 6/26/2017.
 */
@RunWith(PortfolioJunit4Runner.class)
@PortfolioJunit4Runner.GuiceModules(HomeModule.class)
public class HomeTest {
    @Inject
    @Rule
    public DriverRule driverRule;

    @Inject
    private HomeNavigator homeNavigator;

    @Inject
    @Named("dependencyInjectionTest")
    private String dependencyInjectionTest;


    @Test
    public void shouldDisplayHomePage()
    {
        HomePage homePage = homeNavigator.getHomePage();

        assertTrue(homePage.isDisplayed());
    }

    @Test
    public void shouldNavToOtherPagesFromHome()
    {
        
    }

    @Test
    public void shouldInjectObjectsFromNestingModules()
    {
        assertThat(dependencyInjectionTest, is ("injected"));
    }
}
