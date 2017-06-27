package portfolio.base.base.driverfactory;

/**
 * Created by Dan on 6/26/2017.
 */

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type)
    {

        switch (type)
        {
            case CHROME:
                return new ChromeDriverManager();
            default:
                return new ChromeDriverManager();
        }
    }
}
