package portfolio.base.base;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.lang.annotation.*;

/**
 * Created by Dan on 6/26/2017.
 *
 * Credit goes to github user sfragis for creating GuiceJUnitRunner from which I took heavy inspiration.
 * https://github.com/sfragis/GuiceJUnitRunner
 */
public class PortfolioJunit4Runner extends BlockJUnit4ClassRunner{
    private Injector injector;

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface GuiceModules{
        Class<?>[] value();
    }

    @Override
    public Object createTest() throws Exception
    {
        Object obj = super.createTest();
        injector.injectMembers(obj);

        return obj;
    }

    /**
     * Initiates testRunner
     * @param testClass
     * @throws InitializationError
     */
    public PortfolioJunit4Runner(Class<?> testClass) throws InitializationError {
        super(testClass);

        Class<?>[] classes = getModulesFor(testClass);
        injector = createInjectorFor(classes);
    }

    private Class<?>[] getModulesFor(Class<?> testClass) throws InitializationError
    {
        GuiceModules annotation = testClass.getAnnotation(GuiceModules.class);
        if(annotation==null)
        {
            throw new InitializationError("Missing @GuiceModules annotation for unit test " + testClass.getName());
        }
        return annotation.value();
    }

    private Injector createInjectorFor(Class<?>[] classes) throws InitializationError
    {
        Module[] modules = new AbstractModule[classes.length];
        for(int i = 0; i < classes.length; i ++)
        {
            try{
                modules[i] = (Module) (classes[i]).newInstance();
            }
            catch(InstantiationException e)
            {
                throw new InitializationError(e);
            }
            catch(IllegalAccessException e)
            {
                throw new InitializationError(e);
            }
        }
        return Guice.createInjector(modules);
    }
}