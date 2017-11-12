import com.productService.dao.ProductDAOImpl;
import com.productService.model.Category;
import com.productService.model.Product;
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
public class ProductTest {
    @Mock
    private static Query query;

    @Test
    public void get_product_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        Product dummy = new Product();
        dummy.setId(1);
        EntityManager em = Mockito.mock(EntityManager.class);

        //Asset
        // Mock the productDao to use our EntityManager
        ProductDAOImpl productDao = new ProductDAOImpl();
        productDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummy);

        //Assert
        // Perform the actual test
        Assert.assertSame(dummy, productDao.getId(1));
    }

    @Test
    public void get_product_list_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        List<Product> dummyList = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(dummyList);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummyList.size(), someDao.getAllProducts().size());
    }

    @Test
    public void get_all_products_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        String codeValue = "RESTAURANT_CODE";
        List<Product> dummyList = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("restaurantCode", codeValue)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummyList);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummyList.size(), someDao.getAllProducts().size());
    }

    @Test
    public void get_all_categories_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        List<Category> dummyList = new ArrayList<>();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(dummyList);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummyList.size(), someDao.getAllCategories().size());
    }

    @Test
    public void get_category_by_id_which_exist() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Category dummy = new Category();
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", idValue)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(dummy);

        // Perform the actual test
        //Assert
        Assert.assertSame(dummy, someDao.getCategoryById(idValue));
    }

    @Test
    public void add_product() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Product productDummy = Mockito.mock(Product.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(productDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.addProduct(productDummy));
    }

    @Test
    public void update_product() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Product productDummy = Mockito.mock(Product.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);
        Mockito.when(productDummy.getId()).thenReturn(idValue);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.updateProduct(productDummy));
    }

    @Test
    public void delete_product() {
        // Mock the EntityManager to return our dummy element
        //Arrange
        int idValue = 1;
        Product productDummy = Mockito.mock(Product.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        // Mock the SomeDao to use our EntityManager
        //Asset
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        Mockito.when(productDummy.getId()).thenReturn(idValue);

        Mockito.when(em.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.setParameter("id", 1)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(productDummy);

        Mockito.when(someDao.getId(idValue)).thenReturn(productDummy);

        // Perform the actual test
        //Assert
        Assert.assertSame(idValue, someDao.deleteProduct(idValue));
    }
}