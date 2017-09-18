package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;
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
public class ProductRestaurantDAO implements IProductRestaurantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductRestaurant getProductRestaurantById(int productRestaurantId) {
        return entityManager.find(ProductRestaurant.class, productRestaurantId);
    }

    @Override
    public void addProductRestaurant(ProductRestaurant productRestaurant) {
        entityManager.persist(productRestaurant);
    }


    @Override
    public void updateProductRestaurant(ProductRestaurant productRestaurant) {
 /*       ProductRestaurant dbProductRestaurant = getProductRestaurant(productRestaurant.);

        dbProductRestaurant.setPrice(productRestaurant.getPrice());
        dbProductRestaurant.setProduct(productRestaurant.getProduct());
        dbProductRestaurant.setRestaurant(productRestaurant.getRestaurant());
        dbProductRestaurant.setName(productRestaurant.getName());
        dbProductRestaurant.setIdSeller(productRestaurant.getIdSeller());
*/
        entityManager.flush();
    }

    @Override
    public boolean ProductRestaurantExists(int idProduct, int idRestaurant) {
        String hql = "FROM ProductRestaurant as pr join Product p join Restaurant r  WHERE p.id = :idProduct and r.id = :idRestaurant";
        int count = entityManager.createQuery(hql).setParameter("idProduct", idProduct).setParameter("idRestaurant",idRestaurant).getResultList().size();
        return count > 0 ? true : false;
    }


    @Override
    public void deleteProductRestaurant(int productRestaurantId) {
        ProductRestaurant productRestaurant = getProductRestaurantById(productRestaurantId);
        entityManager.remove(productRestaurant);
    }

    @Override
    public List<ProductRestaurant> getProductRestaurantListByIds(List<Integer> ids) {
        String hql = "FROM ProductRestaurant as p WHERE p.id in (:ids)";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("ids", ids.toArray()).getResultList();
        return restaurants;
    }

    @Override
    public List<ProductRestaurant> getProductListByRestaurantId(int idRestaurant) {
        String hql = "FROM ProductRestaurant as p join p.restaurant as r join p.product as pr WHERE r.id = :idRestaurant";
        List<ProductRestaurant>  restaurants = entityManager.createQuery(hql).setParameter("idRestaurant", idRestaurant).getResultList();
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

    public void saveOrder(Order order) {
        entityManager.persist(order);
    }
}