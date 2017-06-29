package portfolio.tripplanner;

/**
 * Created by Dan on 6/29/2017.
 *
 * The reason for this enum is that the strings for these search criteria are not consistent between page.
 * On the 'customize your trip' page, Daycre is displayed as "Daycare", but on the results page it's displayed as 'Day Care'.
 */
public enum ResortAmenity {
    SKISCHOOL("Ski School", "Ski School"),
    DAYCARE("Daycare", "Day Care"),
    NIGHTSKIING("Night Skiing", "Night Skiing"),
    ONMOUNTAINBAR("On-mountain Bar", "On Mountain Bar"),
    TERRAINPARK("Terrain Park At Resort","Terrain Park"),
    SKIERSONLY("Skiers Only","Skiers Only"),
    EQUIPMENTRENTAL("Equipment Rental", "Equipment Rental");

    private String customCriteriaName;
    private String resultsName;
    ResortAmenity(String customCriteriaName, String resultsName)
    {
        this.customCriteriaName = customCriteriaName;
        this.resultsName = resultsName;
    }

    public String getCustomCriteriaName()
    {
        return this.customCriteriaName;
    }

    public String getResultsName()
    {
        return this.resultsName;
    }
}
