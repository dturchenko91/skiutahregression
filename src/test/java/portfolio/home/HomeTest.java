package portfolio.home;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.base.base.PortfolioJunit4Runner;
import portfolio.base.base.WebDriverRule;
import portfolio.base.home.HomeNavigator;
import portfolio.base.home.HomePage;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

/**
 * Created by Dan on 6/26/2017.
 */
@RunWith(PortfolioJunit4Runner.class)
@PortfolioJunit4Runner.GuiceModules(HomeModule.class)
public class HomeTest {
    @Inject
    @Rule
    public WebDriverRule webDriverRule;

    @Inject
    private HomeNavigator homeNavigator;

    @Test
    public void shouldDisplayHomePage()
    {
        HomePage homePage = homeNavigator.getHomePage();

        assertTrue(homePage.isDisplayed());
    }
}
