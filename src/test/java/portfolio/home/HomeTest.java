package portfolio.home;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.common.DriverRule;
import portfolio.common.PortfolioJunit4Runner;
import portfolio.resorts.ResortsAndSnowPage;

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

        assertTrue(homePage.basicPageFunctions.isDisplayed());
    }

    @Test
    public void shouldNavToOtherPagesFromHome()
    {
        HomePage homePage = homeNavigator.getHomePage();

        ResortsAndSnowPage resortsAndSnowPage = homePage.basicPageFunctions.getResortsAndSnowPage();

        homePage = resortsAndSnowPage.basicPageFunctions.getHomePage();

        assertTrue(homePage.basicPageFunctions.isDisplayed());
    }

    @Test
    public void shouldInjectObjectsFromNestingModules()
    {
        assertThat(dependencyInjectionTest, is ("injected"));
    }
}
