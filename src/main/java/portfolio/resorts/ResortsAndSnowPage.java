package portfolio.resorts;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;

import javax.inject.Provider;

/**
 * Created by Dan on 6/27/2017.
 */
public class ResortsAndSnowPage extends PageBase {

    @Inject
    public ResortsAndSnowPage(Provider<BasicPageFunctions> basicFunctions)
    {
        super(basicFunctions, By.cssSelector("div#snow-report-summary-sundance"));
    }
}
