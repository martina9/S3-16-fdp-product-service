package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * Created by Martina on 01/10/2017.
 */

public class UpdateProductRestaurant implements Serializable {

    private int id;
    private String name;

    public UpdateProductRestaurant() {
    }

    public UpdateProductRestaurant(int id, String name, int restaurantId, double price, int productId, int quantity) {
        this.id = id;
        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int restaurantId;
    private double price;
    private int productId;
    private int quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
