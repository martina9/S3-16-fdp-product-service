package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class UpdateProductRestaurant implements Serializable {
    private int id;

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
}