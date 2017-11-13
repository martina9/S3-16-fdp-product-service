package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class DeleteRestaurant implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
