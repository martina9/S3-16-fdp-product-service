package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Order;

import java.util.List;

/**
 * Created by Martina
 */

public interface IOrderDAO {

    List<Order> getAllOrders();

    Order getOrderById(int orderId);

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(int orderId); 

    List<Order> getOrdersByUserId(int userId);
}