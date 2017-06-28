package portfolio.common;

import javax.inject.Inject;

/**
 * Created by Dan on 6/26/2017.
 */
public class UrlBuilder {

    private String basePath;
    private String appendedPath = "/";

    @Inject
    public UrlBuilder()
    {
        this.basePath = "https://" + System.getProperty("basepath");
    }

    public UrlBuilder appendPath(String path)
    {
        this.appendedPath = appendedPath + path;
        return this;
    }

    public UrlBuilder replacePath(String path)
    {
        appendedPath = "/" + path;
        return this;
    }

    public String build()
    {
        return basePath + appendedPath;
    }
}
