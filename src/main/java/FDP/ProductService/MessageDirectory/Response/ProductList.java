package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by strom on 01/10/2017.
 */

public class ProductList implements Serializable{

    private List<ProductInfo> items;

    public List<ProductInfo> getItems() {
        return items;
    }

    public void setItems(List<ProductInfo> items) {
        this.items = items;
    }
}
