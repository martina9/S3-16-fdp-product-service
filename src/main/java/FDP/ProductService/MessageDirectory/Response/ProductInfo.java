package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

public class ProductInfo implements Serializable{
    private int id;
    private int categoryId;

    private String name;
    private String categoryName;
    private String code;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param code
     * @param categoryId
     * @param categoryName
     */

    public ProductInfo(int id, String name, String code, int categoryId,String categoryName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    /**
     * Default Constructor
     */

    public ProductInfo() {
    }
    /**
     * Return an void from setId.
     *
     * @param  id

     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return an int from getId.
     *
     */

    public int getId() {
        return id;
    }

    /**
     * Return an void from setName.
     *
     * @param  name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return an void from getName.
     *
     */

    public String getName() {
        return name;
    }

    /**
     * Return an void from setCode.
     *
     * @param  code
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**

     * Return an string from getCode.
     *
     */

    public String getCode() {
        return code;
    }

    /**
     * Return an void from getCategoryId.
     *
     */

    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Return an void from setCategoryId.
     *
     * @param  categoryId
     */

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Return an void from getCategoryName.
     *
     */

    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Return an void from setCategoryName.
     *
     * @param  categoryName
     */

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}