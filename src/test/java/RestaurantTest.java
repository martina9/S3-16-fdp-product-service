import com.productService.dao.RestaurantDAOImpl;
import com.productService.model.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;

/**
 * @author  mGabellini
 */

@RunWith(MockitoJUnitRunner.class)
public class RestaurantTest {
    @Mock
    private static Query query;

    @Test
    public void get_restaurant_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        Restaurant dummy = new Restaurant();
        dummy.setId(1);
        EntityManager em = Mockito.mock(EntityManager.class);

        //Asset
        // Mock the productDao to use our EntityManager
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        restaurantDAO.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummy);

        //Assert
        // Perform the actual test
        Assert.assertSame(dummy, restaurantDAO.getRestaurantById(1));
    }

    @Test
    public void get_restaurant_by_city_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        String city = "Pesaro";
        List<Restaurant> dummy = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        //Asset
        // Mock the productDao to use our EntityManager
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        restaurantDAO.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("city", city)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(dummy);

        //Assert
        // Perform the actual test
        Assert.assertSame(dummy.size(), restaurantDAO.getRestaurantsByCity(city).size());
    }

    @Test
    public void add_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Restaurant restaurantDummy = Mockito.mock(Restaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        RestaurantDAOImpl someDao = new RestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(restaurantDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.addRestaurant(restaurantDummy));
    }

    @Test
    public void update_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Restaurant restaurantDummy = Mockito.mock(Restaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        RestaurantDAOImpl someDao = new RestaurantDAOImpl();
        someDao.setEntityManager(em);
        Mockito.when(restaurantDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.updateRestaurant(restaurantDummy));
    }

    @Test
    public void delete_restaurant() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Restaurant restaurantDummy = Mockito.mock(Restaurant.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        RestaurantDAOImpl someDao = new RestaurantDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(restaurantDummy.getId()).thenReturn(idValue);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(restaurantDummy);

        Mockito.when(someDao.getRestaurantById(idValue)).thenReturn(restaurantDummy);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.deleteRestaurant(idValue));
    }
}