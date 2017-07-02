package portfolio.common;

import com.google.inject.Inject;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dan on 6/30/2017.
 */
public class ScreenshotRule implements TestRule {

    @Inject
    private WebDriver driver;

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try
                {
                    base.evaluate();
                }
                catch (Throwable t)
                {
                    System.err.println("Test " + description.getMethodName() + " failed. Taking screenshot");
                    captureScreenshot(description.getClassName());
                    throw t;
                }
            }
        };
    }

    private void captureScreenshot(String fileName)
    {
        try
        {
            new File("target/surefire-reports/").mkdirs();
            FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }
        catch (IOException e){}
    }
}
