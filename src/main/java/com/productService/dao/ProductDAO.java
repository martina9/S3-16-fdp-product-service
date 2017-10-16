package com.productService.dao;

import com.productService.model.*;

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
        String hql = "SELECT p FROM Product p join p.category where p.id = :id";
        return (Product) entityManager.createQuery(hql).setParameter("id", productId).getSingleResult();
      //  return entityManager.find(Product.class, productId);
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
        String hql = "SELECT p FROM Product p join p.category  ORDER BY p.id";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        String hql = "SELECT p FROM Category p  ORDER BY p.id";
        return (List<Category>) entityManager.createQuery(hql).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Category getCategoryById(int id) {
        String hql = "SELECT p FROM Category p where p.id = :id ORDER BY p.id";
        return (Category) entityManager.createQuery(hql).setParameter("id",id).getSingleResult();
    }
    /**
     * Returns an added product.
     *
     * @param product
     * @return entityManager to add product
     * @see    Product
     */

    @Override
    public int addProduct(Product product) {
        entityManager.persist(product);
        entityManager.flush();
        return product.getId();
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
        entityManager.merge(product);
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
        String hql = "SELECT p FROM Product as p WHERE p.code = :code";
        int count = entityManager.createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }


} 
