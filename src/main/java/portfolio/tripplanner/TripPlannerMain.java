package portfolio.tripplanner;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import portfolio.common.BasicPageFunctions;
import portfolio.common.PageBase;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripPlannerMain extends PageBase
{
    private Provider<TripPlannerResults> results;
    private Provider<TripCustomizer> customizer;

    @Inject
    public TripPlannerMain(Provider<BasicPageFunctions> basicFunctions, Provider<TripPlannerResults> results, Provider<TripCustomizer> customizer)
    {
        super(basicFunctions, By.cssSelector("a[href='./customize-trip']"));

        this.results = results;
        this.customizer = customizer;
    }

    public TripPlannerResults getFamilyResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-family']")).click();

        return results.get();
    }

    public TripPlannerResults getCouplesResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-couples']")).click();

        return results.get();
    }

    public TripPlannerResults getPowderhoundResults()
    {
        driver.findElement(By.cssSelector("a[href='./new-trip-powderhound']")).click();

        return results.get();
    }

    public TripCustomizer createCustomTrip()
    {
        //driver.findElement(By.cssSelector("a[href='./customize-trip']")).click();

        Actions builder = new Actions(driver);

        builder.click(driver.findElement(By.cssSelector("a[href='./customize-trip']"))).click(driver.findElement(By.cssSelector("a[href='./customize-trip']"))).perform();

        return customizer.get();
    }




}
