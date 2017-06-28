package portfolio.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import portfolio.common.PageBase;
import portfolio.resorts.ResortsAndSnowPage;


import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dan on 6/26/2017.
 */
public class HomePage extends PageBase {

    @Inject
    public HomePage(WebDriver driver, Provider<HomePage> homepage, Provider<ResortsAndSnowPage> resortsAndSnowPage)
    {
        super(driver, homepage, resortsAndSnowPage, By.cssSelector("h1.map-Container-menuTitle"));
    }
}
