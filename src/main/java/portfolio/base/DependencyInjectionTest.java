package portfolio.base;

import javax.inject.Inject;

/**
 * Created by Dan on 6/26/2017.
 */
public class DependencyInjectionTest {

    private String testString;

    @Inject
    public DependencyInjectionTest()
    {
        this.testString = "injected";
    }

    public String getTestString()
    {
        return this.testString;
    }
}
