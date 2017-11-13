import FDP.ProductService.MessageDirectory.Request.AddProductRestaurant;
import FDP.ProductService.MessageDirectory.Request.DeleteProductRestaurant;
import FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo;
import FDP.ProductService.MessageDirectory.Request.UpdateProductRestaurant;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.model.ProductRestaurant;
import com.productService.service.ProductRestaurantMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

/**
 * @author  mGabellini
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductRestaurantMessageTest {
    @Test
    public void get_product_restaurant_info_request_message() throws Exception {

        //Arrange
        int idValue = 1;
        ProductRestaurant productRestaurant = Mockito.mock(ProductRestaurant.class);
        FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo infoRequest = Mockito.mock(ProductRestaurantInfo.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo response = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo();
        response.setId(idValue);

        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        Mockito.when(productRestaurantMessageService.convertFromProduct(productRestaurant)).thenReturn(response);
        Mockito.when(productRestaurantMessageService.productRestaurantById(infoRequest)).thenReturn(response);

        //Act
        FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo expectedResponse = productRestaurantMessageService.productRestaurantById(infoRequest);

        //Assert
        Assert.assertSame(response.getId(), expectedResponse.getId());
    }


    @Test
    public void add_product_restaurant_request_message() throws Exception {

        //Arrange
        AddProductRestaurant requestAddProductRestaurant = Mockito.mock(AddProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.AddProductRestaurant expectedResponse = new FDP.ProductService.MessageDirectory.Response.AddProductRestaurant();
        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        Mockito.when(productRestaurantMessageService.addProductRestaurant(requestAddProductRestaurant)).thenReturn(expectedResponse);

        //Act
        FDP.ProductService.MessageDirectory.Response.AddProductRestaurant response = productRestaurantMessageService.addProductRestaurant(requestAddProductRestaurant);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }

    @Test
    public void update_product_restaurant_request_message() throws Exception {
        //Arrange
        UpdateProductRestaurant requestUpdateProductRestaurant = Mockito.mock(UpdateProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.UpdateProductRestaurant expectedResponse = new FDP.ProductService.MessageDirectory.Response.UpdateProductRestaurant();
        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        Mockito.when(productRestaurantMessageService.updateProductRestaurant(requestUpdateProductRestaurant)).thenReturn(expectedResponse);

        //Act
        FDP.ProductService.MessageDirectory.Response.UpdateProductRestaurant response = productRestaurantMessageService.updateProductRestaurant(requestUpdateProductRestaurant);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }

    @Test
    public void delete_product_restaurant_request_message() throws Exception {
        //Arrange
        DeleteProductRestaurant requestDeleteProduct = Mockito.mock(DeleteProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);
        FDP.ProductService.MessageDirectory.Response.DeleteProductRestaurant response = new FDP.ProductService.MessageDirectory.Response.DeleteProductRestaurant();
        ProductRestaurantMessageService productRestaurantMessageService = Mockito.mock(ProductRestaurantMessageService.class);
        Mockito.when(productRestaurantMessageService.deleteProductRestaurant(requestDeleteProduct)).thenReturn(response);

        //Act
        FDP.ProductService.MessageDirectory.Response.DeleteProductRestaurant expectedResponse = productRestaurantMessageService.deleteProductRestaurant(requestDeleteProduct);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }
}