package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.OrderDAO;
import com.fastdeliveryservice.dao.ProductDAO;
import com.fastdeliveryservice.dao.UserDAO;
import com.fastdeliveryservice.domain.OrderDto;
import com.fastdeliveryservice.model.Order;
import com.fastdeliveryservice.model.OrderProduct;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fastdeliveryservice.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author  mGabellini
 */

@Component
public class OrderMessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    public OrderMessageService(Environment environment, RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.AddOrder")
    private boolean AddOrderById(OrderDto orderDto) {
        logger.debug("Sending RPC response message with id of created order...");
        List<Integer> ids =  orderDto.getProductRestaurants().stream().map(u -> u.getId()).collect(Collectors.toList());
        List<ProductRestaurant> restaurants = productDAO.getProductRestaurantList(ids);
        Order order = new Order();
        order.setConfirmationDate(new java.sql.Date(System.currentTimeMillis()));
        int totalPrice = 0;
        for (ProductRestaurant products : restaurants ) {
            totalPrice+=products.getPrice();
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(1);
            orderProduct.setProductRestaurant(products);
            order.getOrderProducts().add(orderProduct);
        }
        order.setDeliveryType(orderDto.getDeliveryType());
        order.setNetPrice(totalPrice);
        User user = userDAO.getUserById(orderDto.getUserId());
        order.setUser(user);
        orderDAO.addOrder(order);
        return true;
    }

    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.UpdateOrder")
    private boolean UpdateOrder(OrderDto orderDto) {
        logger.debug("Sending RPC response message with id of created order...");
        List<Integer> ids =  orderDto.getProductRestaurants().stream().map(u -> u.getId()).collect(Collectors.toList());
        List<ProductRestaurant> restaurants = productDAO.getProductRestaurantList(ids);
        Order order = new Order();
        order.setConfirmationDate(new java.sql.Date(System.currentTimeMillis()));
      //  User user = productDAO.getUser(orderDto.getUser().getEmail());
      //  order.setUser(user);
        order.setNetPrice(200);

        return true;
    }

    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.Order")
    private String getOrderById(int id) {
        logger.debug("Request message: {}", id);
        logger.debug("Sending RPC response message with list of Orders...");

        Order order = orderDAO.getOrderById(id);

        return serializeToJson(order);
    }

    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.OrderList")
    private String getOrdersByUserId(int userId) {
        logger.debug("Request message: {}", userId);
        logger.debug("Sending RPC response message with list of Orders...");

        List<Order> orders = orderDAO.getOrdersByUserId(userId);

        return serializeToJson(orders);
    }

    private String serializeToJson(List<Order> orders) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        final Map<String, List<Order>> dataMap = new HashMap<>();
        dataMap.put("orders", orders);

        try {
            jsonInString = mapper.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }

    private String serializeToJson(Order order) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }

}
