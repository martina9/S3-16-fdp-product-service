package com.productService.dao;

import com.productService.model.Order;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface IOrderDAO {

    /**
     * Returns an List<Order> implementation this interface.
     *
     * @return List<Order>
     * @see    Order
     */

    List<Order> getAllOrders();

    /**
     * Returns an Order by orderId implementation this interface.
     *
     * @return Order
     * @see    Order
     */

    Order getOrderById(int orderId);

    /**
     * Returns an Order by orderId implementation this interface.
     *
     * @param order to add
     * @return void
     * @see    Order
     */

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(int orderId); 

    List<Order> getOrdersByUserId(int userId);
}