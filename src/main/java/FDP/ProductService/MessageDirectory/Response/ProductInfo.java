package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;

/**
 * Created by strom on 01/10/2017.
 */
public class ProductInfo implements Serializable{


    private int id;

    private String name;
    private String categoryName;
    private String code ;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductInfo(){


    }

    public ProductInfo(int id, String name, String code, int categoryId,String categoryName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryId = categoryId;
        this.categoryName = categoryName;

    }

    private int categoryId;

    /**
     * Returns an void from setId.
     *
     * @param  id

     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns an void from getId.
     *
     */

    public int getId() {
        return id;
    }


    /**
     * Returns an void from setName.
     *
     * @param  name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns an void from getName.
     *
     */

    public String getName() {
        return name;
    }


    /**
     * Returns an void from setCode.
     *
     * @param  code
     */

    public void setCode(String code) {
        this.code = code;
    }



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**

     * Returns an string from getCode.
     *
     */

    public String getCode() {
        return code;
    }

}
