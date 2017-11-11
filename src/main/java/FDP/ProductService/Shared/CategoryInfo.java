package FDP.ProductService.Shared;

/**
 * @author  mGabellini
 */

public class CategoryInfo {
    private int id;

    private String name;

    /**
     * Constructor
     *
     * @param id
     * @param name
     */

    public CategoryInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns an void from getId.
     *
     */

    public int getId() {
        return id;
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
     * Return an void from getName.
     *
     */

    public String getName() {
        return name;
    }

    /**
     * Return an void from setName.
     *
     * @param  name

     */

    public void setName(String name) {
        this.name = name;
    }
}
