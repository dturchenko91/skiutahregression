package portfolio.search;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dan on 7/4/2017.
 */
public class SearchResultsPage extends PageBase {

    @Inject
    public SearchResultsPage(Provider<BasicPageFunctions> basicFunctions) {
        super(basicFunctions, By.cssSelector("h2.SearchResults-title"));
    }

    public List<SearchResult> getResults()
    {
        List<WebElement> searchResultElements = driver.findElement(By.cssSelector("div.SearchResults")).findElements(By.xpath("*"));
        List<SearchResult> output = new ArrayList<>();
        for(WebElement result: searchResultElements)
        {
            if(result.getClass().equals("SearchResults-title"))
            {
                int index = searchResultElements.indexOf(result)+1;
                output.add(new SearchResult(By.cssSelector("h2.SearchResults-title:nth-child("+index+")>a")));
            }
        }

        return output;
    }

    public List<SearchResult> getResults(int limit)
    {
        List<WebElement> searchResultElements = driver.findElement(By.cssSelector("div.SearchResults")).findElements(By.xpath("*"));
        List<SearchResult> output = new ArrayList<>();
        for(WebElement result: searchResultElements)
        {
            if(result.getAttribute("class").equals("SearchResults-title"))
            {
                int index = searchResultElements.indexOf(result)+1;
                output.add(new SearchResult(By.cssSelector("h2.SearchResults-title:nth-child("+index+")>a")));
                if(output.size()==limit)
                    return output;
            }
        }

        return output;
    }

    public class SearchResult
    {
        private By titleContainer;

        public SearchResult(By titleContainer)
        {
            this.titleContainer = titleContainer;
        }

        public String getTitle()
        {
            return driver.findElement(titleContainer).getText();
        }

        public void followLink()
        {
            driver.findElement(titleContainer).click();
        }
    }
}
