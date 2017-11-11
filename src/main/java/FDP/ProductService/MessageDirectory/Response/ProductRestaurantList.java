package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  mGabellini
 */

public class ProductRestaurantList implements Serializable {

    /**
     * Constructor
     *
     */

    public ProductRestaurantList() {
        items = new ArrayList<>();
    }

    private List<ProductRestaurantInfo> items;

    /**
     * Return a list of items ProductRestaurantInfo.
     *
     * @return List<ProductRestaurantInfo>
     */

    public List<ProductRestaurantInfo> getItems() {
        return items;
    }

    /**
     * Return a void from setItems.
     *
     * @param items
     */

    public void setItems(List<ProductRestaurantInfo> items) {
        this.items = items;
    }
}
