import FDP.ProductService.MessageDirectory.Request.ProductInfo;
import FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo;
import FDP.ProductService.MessageDirectory.Request.ProductRestaurantList;
import com.productService.dao.ProductDAOImpl;
import com.productService.dao.ProductRestaurantDAO;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.model.Product;

import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;
import com.productService.service.ProductMessageService;
import com.productService.service.ProductRestaurantMessageService;
import org.junit.Assert;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * @author  mGabellini
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductRestaurantMessageTest {
    @Test
    public void get_product_restaurant_info_request_message() throws Exception {
        int idValue = 1;

        ProductRestaurant productRestaurant = Mockito.mock(ProductRestaurant.class);
        ProductRestaurantInfo infoRequest = Mockito.mock(ProductRestaurantInfo.class);
        infoRequest.setId(idValue);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset

        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo response = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo();
        response.setId(idValue);

        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        Mockito.when(productRestaurantMessageService.ConvertFromProduct(productRestaurant)).thenReturn(response);
        Mockito.when(productRestaurantMessageService.ProductRestaurantById(infoRequest)).thenReturn(response);

        // Perform the actual test
        //Assert
        Assert.assertSame(response, productRestaurantMessageService.ProductRestaurantById(infoRequest));
    }

    @Test
    public void get_product_restaurant_list_info_request_message() throws Exception {
        int idValue = 1;

        // Mock the SomeDao to use our EntityManager
        //Asset

        ProductRestaurant productRestaurant = Mockito.mock(ProductRestaurant.class);
        ProductRestaurantList productRestaurantListRequest = Mockito.mock(ProductRestaurantList.class);

        EntityManager em = Mockito.mock(EntityManager.class);
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.ProductRestaurantList response = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantList();

        List<ProductRestaurant> productRestaurants =  someDao.getProductListByRestaurantId(idValue);

        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        //Mockito.when(productRestaurantMessageService.ConvertFromProduct(productRestaurant)).thenReturn(response);
        Mockito.when(productRestaurantMessageService.ProductRestaurantList(productRestaurantListRequest)).thenReturn(response);

        // Perform the actual test
        //Assert
        Assert.assertSame(response, productRestaurantMessageService.ProductRestaurantList(productRestaurantListRequest));
    }

    @Test
    public void add_product_restaurant_request_message() throws Exception {
        // Mock the SomeDao to use our EntityManager
        //Asset

        ProductRestaurant productRestaurant = Mockito.mock(ProductRestaurant.class);
        Product product = Mockito.mock(Product.class);
        Restaurant restaurant = Mockito.mock(Restaurant.class);


    }
}