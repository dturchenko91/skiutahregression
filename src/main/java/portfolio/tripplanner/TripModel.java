package portfolio.tripplanner;

import java.util.List;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripModel
{
    private List<String> amenities;

    public TripModel(List<String> amenities)
    {
        this.amenities = amenities;
    }

    public List<String> getAmenities()
    {
        return this.amenities;
    }
}
