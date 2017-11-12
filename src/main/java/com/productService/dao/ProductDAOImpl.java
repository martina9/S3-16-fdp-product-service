package com.productService.dao;

import com.productService.model.*;

import javax.persistence.EntityManager;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Preconditions;
import org.hibernate.SessionFactory;
import org.mockito.Mockito;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;

/**
 * @author  mGabellini
 */

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Return an Product by id using query.
     *
     * @return Product
     */

    @Override
    public Product getId(int productId) {
        Preconditions.checkArgument(productId != 0,  "Must be a valid Id");
        String hql = "SELECT p FROM Product p join p.category where p.id = :id";
        return (Product) getEntityManager().createQuery(hql).setParameter("id", productId).getSingleResult();
    }

    /**
     * Return an List<Product> using query.
     *
     * @return List<Product>
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        String hql = "SELECT p FROM Product p join p.category  ORDER BY p.id";
        return (List<Product>) getEntityManager().createQuery(hql).getResultList();
    }

    /**
     * Return an list of Category.
     *
     * @return List<Category>
     */

    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        String hql = "SELECT c FROM Category c  ORDER BY c.id";
        return (List<Category>) getEntityManager().createQuery(hql).getResultList();
    }

    /**
     * Return an Category by id.
     *
     * @param id
     * @return Category
     */

    @SuppressWarnings("unchecked")
    public Category getCategoryById(int id) {
        String hql = "SELECT p FROM Category p where p.id = :id ORDER BY p.id";
        return (Category) getEntityManager().createQuery(hql).setParameter("id",id).getSingleResult();
    }

    /**
     * Return an added product.
     *
     * @param product
     * @return entityManager to add product
     */

    @Override
    public int addProduct(Product product) {
        getEntityManager().persist(product);
        getEntityManager().flush();
        return product.getId();
    }

    /**
     * Return an updated product.
     *
     * @param product
     * @return entityManager to update product
     */

    @Override
    public void updateProduct(Product product) {
        getEntityManager().merge(product);
    }

    /**
     * Return an deleted product.
     *
     * @param productId
     * @return entityManager to remove product by id
     */

    @Override
    public void deleteProduct(int productId) {
        getEntityManager().remove(getId(productId));
    }

    /**
     * Return an count to check if product exists.
     *
     * @param code product
     * @return boolean to query product from code
     */

    @Override
    public boolean ProductExists(String code) {
        String hql = "SELECT p FROM Product as p WHERE p.code = :code";
        int count = getEntityManager().createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }
}