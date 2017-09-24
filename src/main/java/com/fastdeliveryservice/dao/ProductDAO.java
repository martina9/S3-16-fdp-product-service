package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;
import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fastdeliveryservice.model.User;

import javax.persistence.EntityManager;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;

/**
 * @author  mGabellini
 */

@Transactional
@Repository
public class ProductDAO implements IProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns an Product by id using query.
     *
     * @return Product
     * @see    Product
     */

    @Override
    public Product getId(int productId) {
        return entityManager.find(Product.class, productId);
    }

    /**
     * Returns an List<Product> using query.
     *
     * @return List<Product>
     * @see    Product
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        String hql = "FROM Product as atcl ORDER BY atcl.id";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    /**
     * Returns an added product.
     *
     * @param product
     * @return entityManager to add product
     * @see    Product
     */

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    /**
     * Returns an updated product.
     *
     * @param product
     * @return entityManager to update product
     * @see    Product
     */

    @Override
    public void updateProduct(Product product) {
        Product dbProduct = getId(product.getId());
        //dbProduct.setCode(product.getCode());
        dbProduct.setCategory(product.getCategory());
        entityManager.flush();
    }

    /**
     * Returns an deleted product.
     *
     * @param productId
     * @return entityManager to remove product by id
     * @see    Product
     */

    @Override
    public void deleteProduct(int productId) {
        entityManager.remove(getId(productId));
    }

    /**
     * Returns an count to check if product exists.
     *
     * @param code product
     * @return boolean to query product from code
     * @see    boolean
     */

    @Override
    public boolean ProductExists(String code) {
        String hql = "FROM Product as p WHERE p.code = :code";
        int count = entityManager.createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }

    /**
     * Returns an List<ProductRestaurant>.
     *
     * @param ids List restaurants
     * @return List<ProductRestaurant>
     * @see    List<ProductRestaurant>
     */

    @Override
    public List<ProductRestaurant> getProductRestaurantList(List<Integer> ids) {
        String hql = "FROM ProductRestaurant  p WHERE p.id in (:inclList)";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("inclList", ids).getResultList();
        return restaurants;
    }

    /**
     * Returns an getProductRestaurant by id.
     *
     * @param id restaurant
     * @return ProductRestaurant
     * @see    ProductRestaurant
     */

    @Override
    public ProductRestaurant getProductRestaurant(int id) {
        String hql = "FROM ProductRestaurant as p WHERE p.id = :idProductRestaurant";
        ProductRestaurant  restaurant =(ProductRestaurant) entityManager.createQuery(hql).setParameter("idProductRestaurant",id).getSingleResult();
        return restaurant;
    }

    /**
     * Returns an getUser by email.
     *
     * @param email
     * @return User
     * @see    User
     */

    public User getUser(String email) {
        String hql = "FROM User as u WHERE u.email = :email";
        User  user =(User) entityManager.createQuery(hql).setParameter("email",email).getSingleResult();
        return user;
    }

    public void saveOrder(Order order)
    {
        entityManager.persist(order);
    }
} 
