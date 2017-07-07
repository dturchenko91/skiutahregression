package portfolio.search;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import portfolio.common.DriverRuleChain;
import portfolio.common.PortfolioJunit4Runner;
import portfolio.home.HomeNavigator;
import portfolio.home.HomePage;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Dan on 7/4/2017.
 */
@RunWith(PortfolioJunit4Runner.class)
@PortfolioJunit4Runner.GuiceModules(SearchModule.class)
public class SearchTest {

    @Inject
    @Rule
    public DriverRuleChain driverRuleChain;

    @Inject
    private HomeNavigator homeNavigator;

    @Inject
    @Named("snowbird")
    private String searchTestData;

    @Test
    public void shouldGetRelevantSearchResults()
    {
        HomePage homePage = homeNavigator.getHomePage();

        SearchResultsPage resultsPage = homePage.basicPageFunctions.search(searchTestData);

        List<SearchResultsPage.SearchResult> results = resultsPage.getResults(5);

        assertTrue(resultsListContainsDesired(results, searchTestData));
    }

    private boolean resultsListContainsDesired(List<SearchResultsPage.SearchResult> results, String desired)
    {
        for (SearchResultsPage.SearchResult result: results)
        {
            if(result.getTitle().toLowerCase().contains(desired.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
}
