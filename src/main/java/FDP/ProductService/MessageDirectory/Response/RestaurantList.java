package FDP.ProductService.MessageDirectory.Response;

import FDP.ProductService.MessageDirectory.Request.RestaurantInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  mGabellini
 */

public class RestaurantList implements Serializable{
    private List<RestaurantInfo> items;

    public RestaurantList() {
        items = new ArrayList<>();
    }

    /**
     * Return a list of items RestaurantInfo.
     *
     * @return List<RestaurantInfo>
     */

    public List<RestaurantInfo> getItems() {
        return items;
    }

    /**
     * Return a void from setItems.
     *
     * @param items
     */

    public void setItems(List<RestaurantInfo> items) {
        this.items = items;
    }
}
