package FDP.ProductService.MessageDirectory.Response;

import FDP.ProductService.Shared.CategoryInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by strom on 01/10/2017.
 */

public class CategoryList implements Serializable{

    private List<CategoryInfo> items;

    public List<CategoryInfo> getItems() {
        return items;
    }

    public void setItems(List<CategoryInfo> items) {
        this.items = items;
    }
}
