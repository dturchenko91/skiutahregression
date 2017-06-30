package portfolio.home;

import org.openqa.selenium.By;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;


import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dan on 6/26/2017.
 */
public class HomePage extends PageBase {

    @Inject
    public HomePage(Provider<BasicPageFunctions> basicFunctions)
    {
        super(basicFunctions, By.cssSelector("h1.map-Container-menuTitle"));
    }
}
