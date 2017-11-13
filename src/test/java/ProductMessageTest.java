import FDP.ProductService.MessageDirectory.Request.AddProduct;
import FDP.ProductService.MessageDirectory.Request.DeleteProduct;
import FDP.ProductService.MessageDirectory.Request.ProductInfo;
import FDP.ProductService.MessageDirectory.Request.UpdateProduct;
import com.productService.dao.ProductDAOImpl;
import com.productService.model.Product;
import com.productService.service.ProductMessageService;
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
public class ProductMessageTest {
    @Test
    public void get_product_info_request_message() throws Exception {
        int idValue = 1;

        //Arrange
        ProductInfo infoRequest = new ProductInfo();
        infoRequest.setId(idValue);
        Product product = Mockito.mock(Product.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);
        FDP.ProductService.MessageDirectory.Response.ProductInfo expectedResponse = new FDP.ProductService.MessageDirectory.Response.ProductInfo();
        expectedResponse.setId(idValue);
        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        Mockito.when(productMessageService.convertFromProduct(product)).thenReturn(expectedResponse);
        Mockito.when(productMessageService.productInfo(infoRequest)).thenReturn(expectedResponse);

        //Act
        FDP.ProductService.MessageDirectory.Response.ProductInfo response = productMessageService.productInfo(infoRequest);

        //Assert
        Assert.assertSame(expectedResponse.getId(), response.getId());
    }

    @Test
    public void add_product_request_message() throws Exception {

        //Arrange
        AddProduct addProduct = Mockito.mock(AddProduct.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        FDP.ProductService.MessageDirectory.Response.AddProduct expectedResponse = new FDP.ProductService.MessageDirectory.Response.AddProduct();
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);
        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        Mockito.when(productMessageService.addProduct(addProduct)).thenReturn(expectedResponse);

        //Act
        FDP.ProductService.MessageDirectory.Response.AddProduct response = productMessageService.addProduct(addProduct);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }

    @Test
    public void update_product_request_message() throws Exception {

        //Arrange
        UpdateProduct updateProductRequest = Mockito.mock(UpdateProduct.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);
        FDP.ProductService.MessageDirectory.Response.UpdateProduct response = new FDP.ProductService.MessageDirectory.Response.UpdateProduct();
        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        Mockito.when(productMessageService.updateProduct(updateProductRequest)).thenReturn(response);

        //Act
        FDP.ProductService.MessageDirectory.Response.UpdateProduct expectedResponse = productMessageService.updateProduct(updateProductRequest);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }

    @Test
    public void delete_product_request_message() throws Exception {

        //Arrange
        DeleteProduct requestDeleteProduct = Mockito.mock(DeleteProduct.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        ProductDAOImpl someDao = new ProductDAOImpl();
        someDao.setEntityManager(em);
        FDP.ProductService.MessageDirectory.Response.DeleteProduct response = new FDP.ProductService.MessageDirectory.Response.DeleteProduct();
        ProductMessageService productMessageService = Mockito.mock(ProductMessageService.class);
        Mockito.when(productMessageService.deleteProduct(requestDeleteProduct)).thenReturn(response);

        //Act
        FDP.ProductService.MessageDirectory.Response.DeleteProduct expectedResponse = productMessageService.deleteProduct(requestDeleteProduct);

        //Assert
        Assert.assertSame(expectedResponse, response);
    }
}