package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Martina on 11/08/2017.
 */
@Transactional
@Repository
public class ProductDAO implements IProductDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Product getProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        String hql = "FROM Product as atcl ORDER BY atcl.ProductId";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }
    @Override
    public void updateProduct(Product product) {
        Product dbProduct = getProductById(product.getId());
        dbProduct.setCode(product.getCode());
        dbProduct.setCategory(product.getCategory());
        entityManager.flush();
    }
    @Override
    public void deleteProduct(int productId) {
        entityManager.remove(getProductById(productId));
    }

    @Override
    public boolean ProductExists(String code) {
        String hql = "FROM Products as p WHERE p.code = ?";
        int count = entityManager.createQuery(hql).setParameter(1, code).getResultList().size();
        return count > 0 ? true : false;
    }
} 
