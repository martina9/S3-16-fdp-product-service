package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class DeleteProduct implements Serializable {
    private int id;

    /**
     * Returns an int from getId.
     *
     */

    public int getId() {
        return id;
    }

    /**

     * Returns an void from setId.
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }
}
