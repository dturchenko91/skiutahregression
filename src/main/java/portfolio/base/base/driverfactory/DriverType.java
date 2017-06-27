package portfolio.base.base.driverfactory;

/**
 * Created by Dan on 6/26/2017.
 */
public enum DriverType {
    CHROME ("chrome"),
    FIREFOX ("firefox"),
    PHANTOMJS ("phantomjs");

    private String name;
    DriverType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
