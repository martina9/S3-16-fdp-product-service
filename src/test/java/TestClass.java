import com.productService.dao.ProductDAO;
import com.productService.dao.ProductDAOImpl;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.dao.RestaurantDAOImpl;
import com.productService.model.Category;
import com.productService.model.Product;
import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;
import com.sun.java.swing.plaf.motif.MotifCheckBoxMenuItemUI;
import org.junit.Assert;
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
    public void contextLoads() {
    }

    @Mock
    private static Query query;

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
//
//    @Test
//    public void yourMockTest() {
//
//        // create your Mock
//        ProductDAOImpl paymentRepo = new ProductDAOImpl();
//        paymentRepo.setEntityManager(Mockito.mock(EntityManager.class));
//
//        // instantiate your args
//        ProductDAOImpl session = new ProductDAOImpl();
//
//        // instantate return object
//        Product returnMe = new Product();
//        returnMe.setName("Returned");
//        // mock
//        when(paymentRepo.getEntityManager().find(any(), any(), any(), any())).thenReturn(returnMe);
//
//        // execute
//        Object returned = session.getEntityManager().find(clazz, id, otherClazz, session);
//
//        // assert
//        assertEquals(returnMe, returned);
//    }
//

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