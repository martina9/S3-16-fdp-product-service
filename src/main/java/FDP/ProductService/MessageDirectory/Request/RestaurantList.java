package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * Created by Martina on 01/10/2017.
 */

public class RestaurantList implements Serializable{
    public int getId() {
        return id;
    }

    public RestaurantList() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

}
