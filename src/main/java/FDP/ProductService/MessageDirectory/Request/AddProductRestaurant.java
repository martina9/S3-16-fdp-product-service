package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class AddProductRestaurant implements Serializable {
    private int quantity;
    private int restaurantId;
    private int productId;

    private String name;
    private String code;

    private double price;

    /**
     * Constructor
     *
     * @param name
     * @param restaurantId
     * @param code
     * @param productId
     * @param quantity
     */

    public AddProductRestaurant(String name, int restaurantId, double price, String code, int productId, int quantity) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Return an int from getQuantity.
     *
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Return an void from setQuantity.
     *
     * @param quantity
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    /**
     * Returns an double from getPrice.
     *
     */

    public double getPrice() {
        return price;
    }

    /**

     * Return an void from setPrice.
     *
     * @param price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return an String from getName.
     *
     */

    public String getName() {
        return name;
    }

    /**
     * Return an String from setName.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return an String from getCode.
     *
     */

    public String getCode() {
        return code;
    }

    /**
     * Return an void from setCode.
     *
     * @param code
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Return an int from getProductId.
     *
     */

    public int getProductId() {
        return productId;
    }

    /**
     * Return an void from setProductId.
     *
     * @param productId
     */

    public void setProductId(int productId) {
        this.productId = productId;
    }
}