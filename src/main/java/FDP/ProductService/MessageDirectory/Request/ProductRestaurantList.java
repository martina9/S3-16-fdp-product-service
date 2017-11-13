package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class ProductRestaurantList implements Serializable {
    private String restaurantCode;

    private int restaurantId;

    /**
     * Return an String from getRestaurantCode.
     *
     */

    public String getRestaurantCode() {
        return restaurantCode;
    }

    /**

     * Return an void from setRestaurantCode.
     *
     * @param restaurantCode
     */

    public void setRestaurantCode(String restaurantCode) {
        this.restaurantCode = restaurantCode;
    }

    /**
     * Return an int from getRestaurantId.
     *
     */

    public int getRestaurantId() {
        return restaurantId;
    }

    /**

     * Return an void from setRestaurantId.
     *
     * @param restaurantId
     */

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}