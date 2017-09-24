package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fastdeliveryservice.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author  mGabellini
 */

@Transactional
@Repository
public class ProductRestaurantDAO implements IProductRestaurantDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns an productRestaurant by id using query.
     *
     * @param productRestaurantId
     * @return ProductRestaurant
     * @see    ProductRestaurant
     */

    @Override
    public ProductRestaurant getProductRestaurantById(int productRestaurantId) {
        return entityManager.find(ProductRestaurant.class, productRestaurantId);
    }

    /**
     * Returns an added ProductRestaurant.
     *
     * @param productRestaurant
     */

    @Override
    public int addProductRestaurant(ProductRestaurant productRestaurant) {

        entityManager.persist(productRestaurant);
        entityManager.flush();
        return productRestaurant.getId();
    }

    /**
     * Returns an updated ProductRestaurant.
     *
     * @param productRestaurant
     */

    @Override
    public void updateProductRestaurant(ProductRestaurant productRestaurant) {
//        ProductRestaurant dbProductRestaurant = getProductRestaurant(productRestaurant.getId());
//
//        dbProductRestaurant.setPrice(productRestaurant.getPrice());
//        dbProductRestaurant.setProduct(productRestaurant.getProduct());
//        dbProductRestaurant.setRestaurant(productRestaurant.getRestaurant());
//        dbProductRestaurant.setName(productRestaurant.getName());
//        dbProductRestaurant.setProduct(productRestaurant.getProduct());

        entityManager.merge(productRestaurant);
    }

    /**
     * Returns an count to check if ProductRestaurant exists.
     *
     * @param idProduct
     * @param idRestaurant
     * @return boolean to query product from idProduct and idRestaurant
     * @see    boolean
     */

    @Override
    public boolean ProductRestaurantExists(int idProduct, int idRestaurant) {
        String hql = "Select pr FROM ProductRestaurant as pr join Product p join Restaurant r  WHERE p.id = :idProduct and r.id = :idRestaurant";
        int count = entityManager.createQuery(hql).setParameter("idProduct", idProduct).setParameter("idRestaurant",idRestaurant).getResultList().size();
        return count > 0 ? true : false;
    }


    /**
     * Returns an deleted ProductRestaurant.
     *
     * @param productRestaurantId
     */

    @Override
    public void deleteProductRestaurant(int productRestaurantId) {
        ProductRestaurant productRestaurant = getProductRestaurantById(productRestaurantId);
        entityManager.remove(productRestaurant);
    }

    /**
     * Returns an List<ProductRestaurant>.
     *
     * @param ids List restaurants
     * @return List<ProductRestaurant>
     * @see    List<ProductRestaurant>
     */

    @Override
    public List<ProductRestaurant> getProductRestaurantListByIds(List<Integer> ids) {
        String hql = "Select p FROM ProductRestaurant as p WHERE p.id in (:ids)";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("ids", ids.toArray()).getResultList();
        return restaurants;
    }

    /**
     * Returns an List<ProductRestaurant>.
     *
     * @param restaurantId
     * @return List<ProductRestaurant>
     * @see    List<ProductRestaurant>
     */

    @Override
    public List<ProductRestaurant> getProductListByRestaurantId(int restaurantId) {
        String hql = "Select p FROM ProductRestaurant as p join p.restaurant as r join p.product as pr WHERE r.id = :idRestaurant";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("idRestaurant", restaurantId).getResultList();
        return restaurants;
    }

    /**
     * Returns an List<ProductRestaurant>.
     *
     * @param restaurantCode
     * @return List<ProductRestaurant>
     * @see    List<ProductRestaurant>
     */

    @Override
    public List<ProductRestaurant> getProductListByRestaurantCode(String restaurantCode) {
        String hql = "Select p FROM ProductRestaurant as p join p.restaurant as r join p.product as pr WHERE r.code = :restaurantCode";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("restaurantCode", restaurantCode).getResultList();
        return restaurants;
    }

    /**
     * Returns an List<ProductRestaurant>.
     *
     * @param id
     * @return List<ProductRestaurant>
     * @see    List<ProductRestaurant>
     */

    @Override
    public ProductRestaurant getProductRestaurant(int id) {
        String hql = "Select p FROM ProductRestaurant as p WHERE p.id = :idProductRestaurant";
        ProductRestaurant  restaurant =(ProductRestaurant) entityManager.createQuery(hql).setParameter("idProductRestaurant",id).getSingleResult();
        return restaurant;
    }

    /**
     * Returns an User from email.
     *
     * @param email
     * @return User
     * @see    User
     */

    public User getUser(String email) {
        String hql = "select u FROM User as u WHERE u.email = :email";
        User  user =(User) entityManager.createQuery(hql).setParameter("email",email).getSingleResult();
        return user;
    }

    public void saveOrder(Order order) {
        entityManager.persist(order);
    }
}