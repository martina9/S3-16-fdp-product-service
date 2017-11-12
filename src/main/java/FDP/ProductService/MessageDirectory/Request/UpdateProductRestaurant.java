package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class UpdateProductRestaurant implements Serializable {
    private int id;
    private int restaurantId;
    private int productId;
    private int quantity;

    private String name;


    private double price;


    /**
     * Default Constructor
     **/

    public UpdateProductRestaurant() {
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param restaurantId
     * @param price
     * @param productId
     * @param quantity
     */

    public UpdateProductRestaurant(int id, String name, int restaurantId, double price, int productId, int quantity) {
        this.id = id;
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
     * Return an int from getId.
     *
     */

    public int getId() {
        return id;
    }

    /**
     * Return an void from setId.
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
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
     * Return an double from getPrice.
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
     * Return an void from setName.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
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