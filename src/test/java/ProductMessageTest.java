import FDP.ProductService.MessageDirectory.Request.AddProduct;
import FDP.ProductService.MessageDirectory.Request.ProductInfo;

import com.productService.dao.ProductDAOImpl;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.model.Product;

import com.productService.service.ProductMessageService;

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
public class ProductMessageTest {
    @Test
    public void get_product_info_request_message() throws Exception {
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

        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        Mockito.when(productMessageService.ConvertFromProduct(product)).thenReturn(response);
        Mockito.when(productMessageService.ProductInfo(infoRequest)).thenReturn(response);

        // Perform the actual test
        //Assert
        Assert.assertSame(response, productMessageService.ProductInfo(infoRequest));
    }

    @Test
    public void add_product_request_message() throws Exception {
        // Mock the SomeDao to use our EntityManager
        //Asset

        AddProduct addProduct = Mockito.mock(AddProduct.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);

        FDP.ProductService.MessageDirectory.Response.AddProduct response = new FDP.ProductService.MessageDirectory.Response.AddProduct();

        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        //Mockito.when(productMessageService.ConvertFromProduct(addProduct)).thenReturn(response);
    }
}