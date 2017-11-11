package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class ProductList implements Serializable {
    public int id;

    private String code;

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
     * Return an String from getId.
     *
     */

    public String getCode() {
        return code;
    }

    /**
     * Return an void from setId.
     *
     * @param code
     */

    public void setCode(String code) {
        this.code = code;
    }
}