package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class AddProduct implements Serializable {
    private String name;
    private String code;

    private int categoryId;

    /**
     * Returns an int from getName.
     *
     */

    public String getName() {
        return name;
    }

    /**
     * Return an void from setName.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return an int from getCode.
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

    /**
     * Return an int from getCategoryId.
     *
     */

    public int getCategoryId() {
        return categoryId;
    }

    /**

     * Return an void from setCategoryId.
     *
     * @param categoryId
     */

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}