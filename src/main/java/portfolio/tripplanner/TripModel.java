package portfolio.tripplanner;

import java.util.List;

/**
 * Created by Dan on 6/28/2017.
 */
public class TripModel
{
    private List<ResortAmenity> amenities;

    public TripModel(List<ResortAmenity> amenities)
    {
        this.amenities = amenities;
    }

    public List<ResortAmenity> getAmenities()
    {
        return this.amenities;
    }
}
