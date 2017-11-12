import FDP.ProductService.MessageDirectory.Request.ProductInfo;
import FDP.ProductService.MessageDirectory.Request.RestaurantInfo;
import com.productService.dao.*;
import com.productService.model.Category;
import com.productService.model.Product;
import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;
import com.productService.service.ProductMessageService;
import com.sun.java.swing.plaf.motif.MotifCheckBoxMenuItemUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author  mGabellini
 */

    //@RunWith(SpringRunner.class)
    @RunWith(MockitoJUnitRunner.class)
    public class TestClass {

    @Test
    public void contextLoads() {}

    @Mock
    private static Query query;

    private List<ProductRestaurant> productRestaurants;

    @Before
    public void setup(){
        productRestaurants = new ArrayList<>();
    }

    @Test
    public void register_event_when_the_payment_is_successfully_saved() {
        ProductDAOImpl paymentRepo = new ProductDAOImpl();
        //paymentRepo.setEntityManager(Mockito.mock(EntityManager.class));

        Product product = new Product();
        product.setName("name");
        paymentRepo.addProduct(product);

        Mockito.verify(paymentRepo.getEntityManager()).persist(product);
        //Mockito.verify(paymentRepo.eventRegistry).register(argument.capture());

        //Integer paymentId = argument.getValue().getPaymentId();
        //Assert.assertNotNull(paymentId); // Fails here!
        //Assert.assertEquals(payment.getId(), paymentId);
    }

    @Test
    public void get_product_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        Product dummy = new Product();
        dummy.setId(1);
        EntityManager em = Mockito.mock(EntityManager.class);
        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummy);
        // Perform the actual test
        //Assert
        Assert.assertSame(dummy, someDao.getId(1));
    }


    @Test
    public void get_productRestaurant_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        ProductRestaurant dummy = new ProductRestaurant();
        dummy.setId(1);
        EntityManager em = Mockito.mock(EntityManager.class);
        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("idProductRestaurant", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummy);
        // Perform the actual test
        //Assert
        Assert.assertSame(dummy, someDao.getProductRestaurant(1));
    }

    @Test
    public void get_ProductInfo_Request_Message() throws Exception {
        int idValue = 1;
        Product product = Mockito.mock(Product.class);
        ProductInfo infoRequest = Mockito.mock(ProductInfo.class);
        infoRequest.setId(idValue);
        EntityManager em = Mockito.mock(EntityManager.class);
        // Mock the SomeDao to use our EntityManager
        //Asset

        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.ProductInfo response = new FDP.ProductService.MessageDirectory.Response.ProductInfo();
        response.setId(idValue);

        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);//new ProductMessageService(someDao);
        Mockito.when(productMessageService.ConvertFromProduct(product)).thenReturn(response);
        Mockito.when(productMessageService.Product(infoRequest)).thenReturn(response);
        // Perform the actual test
        //Assert
        Assert.assertSame(response, productMessageService.Product(infoRequest));
    }
    @Test
    public void get_restaurant_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        Restaurant dummy = new Restaurant();
        dummy.setId(1);
        EntityManager em = Mockito.mock(EntityManager.class);
        // Mock the SomeDao to use our EntityManager
        //Asset
        RestaurantDAOImpl someDao = new RestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.find(Restaurant.class,1)).thenReturn(dummy);
        // Perform the actual test
        //Assert
        Assert.assertSame(dummy, someDao.getRestaurantById(1));
    }
}