package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class CategoryList implements Serializable {
    private String code;

    /**
     * Return an String from getCode.
     *
     */

    public String getCode() {
        return code;
    }

    /**

     * Return an void from setCode.
     *
     * @param code
     */

    public void setCode(String code) {
        this.code = code;
    }
}