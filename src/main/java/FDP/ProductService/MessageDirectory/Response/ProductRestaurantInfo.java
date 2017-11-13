package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class ProductRestaurantInfo implements Serializable {
    private int id ;
    private int quantity;
    private int productId;
    private int restaurantId;

    private double price;

    private String name;
    private String restaurantName;
    private String productName;

    /**
     * Constructor
     *
     * @param id
     * @param price
     * @param quantity
     * @param name
     * @param productId
     * @param restaurantId
     * @param restaurantName
     * @param productName
     */

    public ProductRestaurantInfo(int id, double price, int quantity, String name, int productId, int restaurantId, String restaurantName, String productName) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.productId = productId;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.productName = productName;
    }

    /**
     * Default Constructor
     */
    public ProductRestaurantInfo() {

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
     * @param  name
     */

    public void setName(String name) {
        this.name = name;
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
     * @param  id
     */

    public void setId(int id) {
        this.id = id;
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
     * @param  price
     */

    public void setPrice(double price) {
        this.price = price;
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
     * @param  quantity
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * @param  productId
     */

    public void setProductId(int productId) {
        this.productId = productId;
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
     * @param  restaurantId
     */

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Return an String from getRestaurantName.
     *
     */

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Return an String from getProductName.
     *
     */

    public String getProductName() {
        return productName;
    }

    /**
     * Return an void from setProductName.
     *
     * @param  productName
     */

    public void setProductName(String productName) {
        this.productName = productName;
    }
}