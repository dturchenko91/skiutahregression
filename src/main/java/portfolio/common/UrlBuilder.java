package portfolio.common;

import javax.inject.Inject;

/**
 * Created by Dan on 6/26/2017.
 */
public class UrlBuilder {

    private String basePath;

    @Inject
    public UrlBuilder()
    {
        this.basePath = "https://" + System.getProperty("basepath");
    }

    public UrlBuilder appendPath(String path)
    {
        this.basePath = basePath + "/" + path;
        return this;
    }

    public UrlBuilder replacePath(String path)
    {

        return new UrlBuilder().appendPath(path);
    }

    public String build()
    {
        return basePath + "/";
    }
}
