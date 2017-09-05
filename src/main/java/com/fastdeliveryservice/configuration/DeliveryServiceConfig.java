package com.fastdeliveryservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Martina Gabellini
 */

@Configuration
public class DeliveryServiceConfig {

    /**
     * Used for RPC IPC example
     *
     * @return
     */

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("deliveryService.rpc");
    }

    /**
     * Used for eventually consistent example
     *
     * @return
     */

    /* Product Restaurant*/

    @Bean
    public Queue queueProductRestaurant() {
        return new Queue("FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantId");
    }

    @Bean
    public Binding bindingProductRestaurant(DirectExchange exchange, @Qualifier("queueProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantId");
    }

    @Bean
    public Queue queueAddProductRestaurant() {
        return new Queue("FDP.DeliveryMessageService:Request.AddProductRestaurant");
    }

    @Bean
    public Binding bindingAddProductRestaurant(DirectExchange exchange, @Qualifier("queueProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.AddProductRestaurant");
    }

    @Bean
    public Queue queueUpdateProductRestaurant() {
        return new Queue("FDP.DeliveryMessageService:Request.UpdateProductRestaurant");
    }

    @Bean
    public Binding bindingUpdateProductRestaurant(DirectExchange exchange, @Qualifier("queueProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.UpdateProductRestaurant");
    }

    @Bean
    public Queue queueDeleteProductRestaurant() {
        return new Queue("FDP.DeliveryMessageService:Request.DeleteProductRestaurant");
    }

    @Bean
    public Binding bindingDeleteProductRestaurant(DirectExchange exchange, @Qualifier("queueProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.DeleteProductRestaurant");
    }


    /* End product Restaurant*/

    @Bean
    public Queue QueueRestaurantList() {
        return new Queue("FDP.DeliveryMessageService:Request.RestaurantList");
    }

    @Bean
    public Binding bindingRestaurantList(DirectExchange exchange, @Qualifier("QueueRestaurantList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.RestaurantList");
    }

    @Bean
    public Queue QueueOrderList() {
        return new Queue("FDP.DeliveryMessageService:Request.OrderList");
    }


    @Bean
    public Queue QueueOrder() {
        return new Queue("FDP.DeliveryMessageService:Request.Order");
    }

    @Bean
    public Queue QueueAddOrder() {
        return new Queue("FDP.DeliveryMessageService:Request.AddOrder");
    }

    @Bean
    public Queue QueueUpdateOrder() {
        return new Queue("FDP.DeliveryMessageService:Request.UpdateOrder");
    }

    @Bean
    public Binding bindingOrderList(DirectExchange exchange, @Qualifier("QueueOrderList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.OrderList");
    }

    @Bean
    public Binding bindingOrder(DirectExchange exchange, @Qualifier("QueueOrder") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.Order");
    }

    @Bean
    public Binding bindingAddOrder(DirectExchange exchange, @Qualifier("QueueAddOrder") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.AddOrder");
    }

    @Bean
    public Binding bindingUpdateOrder(DirectExchange exchange, @Qualifier("QueueUpdateOrder") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.DeliveryMessageService:Request.UpdateOrder");
    }

    /**
     * Used for RPC IPC example
     *
     * @return
     */

    @Bean
    public Queue queueRestaurantList() {
            return new Queue("deliveryService.rpc.restaurantList");
    }

    @Bean
    public Binding binding(DirectExchange exchange, @Qualifier("queueRestaurantList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("rpc");
    }
}