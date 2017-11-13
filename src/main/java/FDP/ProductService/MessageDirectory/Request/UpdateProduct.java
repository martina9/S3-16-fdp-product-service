package FDP.ProductService.MessageDirectory.Request;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class UpdateProduct  implements Serializable {
    private int id;
    private int categoryId;

    private String name;
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
     * Return an String from getName.
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
     * Returns an String from getCode.
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
