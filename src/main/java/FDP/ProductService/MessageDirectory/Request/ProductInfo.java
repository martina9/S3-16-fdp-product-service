package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class ProductInfo implements Serializable {
    public int id ;

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

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id  +'}';
    }
}