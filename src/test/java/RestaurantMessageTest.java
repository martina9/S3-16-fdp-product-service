import FDP.ProductService.MessageDirectory.Request.ProductInfo;
import FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo;
import FDP.ProductService.MessageDirectory.Request.ProductRestaurantList;
import com.productService.dao.ProductDAOImpl;
import com.productService.dao.ProductRestaurantDAO;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.model.Product;

import com.productService.model.ProductRestaurant;
import com.productService.service.ProductMessageService;
import com.productService.service.ProductRestaurantMessageService;
import org.junit.Assert;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author  mGabellini
 */

@RunWith(MockitoJUnitRunner.class)
public class RestaurantMessageTest {
    @Test
    public void get_restaurant_info_request_message() throws Exception {
        int idValue = 1;


    }


}