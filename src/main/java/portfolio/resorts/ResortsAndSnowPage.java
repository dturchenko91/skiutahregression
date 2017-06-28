package portfolio.resorts;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import portfolio.common.PageBase;
import portfolio.home.HomePage;

import javax.inject.Provider;

/**
 * Created by Dan on 6/27/2017.
 */
public class ResortsAndSnowPage extends PageBase {

    @Inject
    public ResortsAndSnowPage(WebDriver driver, Provider<HomePage> homepage, Provider<ResortsAndSnowPage> resortsAndSnowPage)
    {
        super(driver, homepage, resortsAndSnowPage, By.cssSelector("div#snow-report-summary-sundance"));
    }
}
