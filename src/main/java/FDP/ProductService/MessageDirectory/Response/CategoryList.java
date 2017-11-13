package FDP.ProductService.MessageDirectory.Response;

import FDP.ProductService.Shared.CategoryInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author  mGabellini
 */

public class CategoryList implements Serializable{
    private List<CategoryInfo> items;

    /**
     * Return a list of items CategoryInfo.
     *
     * @return List<CategoryInfo>
     */

    public List<CategoryInfo> getItems() {
        return items;
    }

    /**
     * Return a void from setItems.
     *
     * @param items
     */

    public void setItems(List<CategoryInfo> items) {
        this.items = items;
    }
}