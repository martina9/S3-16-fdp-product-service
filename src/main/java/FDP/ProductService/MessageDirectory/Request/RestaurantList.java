package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class RestaurantList implements Serializable {
    public int id;

    private String city;

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
     * Return an String from getCity.
     *
     */

    public String getCity() {
        return city;
    }

    /**
     * Return an void from setCity.
     *
     * @param city
     */

    public void setCity(String city) {
        this.city = city;
    }
}