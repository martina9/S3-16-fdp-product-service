package FDP.ProductService.MessageDirectory.Response;

import java.io.Serializable;
import java.util.List;

/**
 * @author  mGabellini
 */

public class ProductList implements Serializable {
    private List<ProductInfo> items;

    /**
     * Return a list of items ProductInfo.
     *
     * @return List<ProductInfo>
     */

    public List<ProductInfo> getItems() {
        return items;
    }

    /**
     * Return a void from setItems.
     *
     * @param items
     */

    public void setItems(List<ProductInfo> items) {
        this.items = items;
    }
}
