package portfolio.home;

import org.openqa.selenium.WebDriver;
import portfolio.common.UrlBuilder;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dan on 6/26/2017.
 */
public class HomeNavigator {

    private WebDriver driver;

    private UrlBuilder urlBuilder;

    private Provider<HomePage> homePage;

    @Inject
    public HomeNavigator(WebDriver driver, UrlBuilder urlBuilder, Provider<HomePage> homePage)
    {
        this.driver = driver;
        this.urlBuilder = urlBuilder;
        this.homePage = homePage;
    }

    public HomePage getHomePage()
    {
        urlBuilder = new UrlBuilder();

        driver.get(urlBuilder.build());

        return homePage.get();
    }
}
