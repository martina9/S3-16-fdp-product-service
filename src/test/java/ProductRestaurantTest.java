import com.productService.dao.ProductRestaurantDAOImpl;

import com.productService.model.ProductRestaurant;

import org.junit.Assert;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyString;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

/**
 * @author  mGabellini
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductRestaurantTest {
    @Mock
    private static Query query;

    @Test
    public void get_product_restaurant_by_id_which_exist() {
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
    public void get_product_restaurant_list_by_restaurant_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        List<ProductRestaurant> dummyList = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("idRestaurant", idValue)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(dummyList);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummyList.size(), someDao.getProductListByRestaurantId(idValue).size());
    }

    @Test
    public void get_product_restaurant_list_by_RestaurantCode_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        String codeValue = "RESTAURANT_CODE";
        List<ProductRestaurant> dummyList = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("restaurantCode", codeValue)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummyList);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummyList.size(), someDao.getProductListByRestaurantCode(codeValue).size());
    }

    @Test
    public void add_product_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        ProductRestaurant productRestaurantDummy = Mockito.mock(ProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(productRestaurantDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.addProductRestaurant(productRestaurantDummy));
    }

    @Test
    public void update_product_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        ProductRestaurant productRestaurantDummy = Mockito.mock(ProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);
        Mockito.when(productRestaurantDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.updateProductRestaurant(productRestaurantDummy));
    }

    @Test
    public void delete_product_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        ProductRestaurant productRestaurantDummy = Mockito.mock(ProductRestaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductRestaurantDAOImpl someDao = new ProductRestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(productRestaurantDummy.getId()).thenReturn(idValue);
        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("idProductRestaurant", idValue)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(productRestaurantDummy);

        Mockito.when(someDao.getProductRestaurant(idValue)).thenReturn(productRestaurantDummy);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.deleteProductRestaurant(idValue));
    }
}