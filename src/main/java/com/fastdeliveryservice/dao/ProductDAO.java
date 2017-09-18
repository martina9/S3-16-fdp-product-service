package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;
import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fastdeliveryservice.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Martina Gabellini
 */

@Transactional
@Repository
public class ProductDAO implements IProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getId(int productId) {
        return entityManager.find(Product.class, productId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        String hql = "FROM Product as atcl ORDER BY atcl.id";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product dbProduct = getId(product.getId());
        //dbProduct.setCode(product.getCode());
        dbProduct.setCategory(product.getCategory());
        entityManager.flush();
    }

    @Override
    public void deleteProduct(int productId) {
        entityManager.remove(getId(productId));
    }

    @Override
    public boolean ProductExists(String code) {
        String hql = "FROM Product as p WHERE p.code = :code";
        int count = entityManager.createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }

    @Override
    public List<ProductRestaurant> getProductRestaurantList(List<Integer> ids) {
        String hql = "FROM ProductRestaurant  p WHERE p.id in (:inclList)";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("inclList", ids).getResultList();
        return restaurants;
    }

    @Override
    public ProductRestaurant getProductRestaurant(int id) {
        String hql = "FROM ProductRestaurant as p WHERE p.id = :idProductRestaurant";
        ProductRestaurant  restaurant =(ProductRestaurant) entityManager.createQuery(hql).setParameter("idProductRestaurant",id).getSingleResult();
        return restaurant;
    }

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
