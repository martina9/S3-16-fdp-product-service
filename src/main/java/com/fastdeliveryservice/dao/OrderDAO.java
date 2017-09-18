package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Martina
 */
@Transactional
@Repository
public class OrderDAO implements IOrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order getOrderById(int orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        String hql = "Select o FROM Order as o join o.user as User WHERE User.Id = :userId";
        List<Order> order = ( List<Order> ) entityManager.createQuery(hql).setParameter("userId", userId).getResultList();
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        String hql = "FROM Order as atcl ORDER BY atcl.Id";
        return (List<Order>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void updateOrder(Order order) {
        Order dbOrder = getOrderById(order.getId());
        dbOrder.setNetPrice(order.getNetPrice());
        entityManager.flush();
    }

    @Override
    public void deleteOrder(int orderId) {
        entityManager.remove(getOrderById(orderId));
    }
} 
