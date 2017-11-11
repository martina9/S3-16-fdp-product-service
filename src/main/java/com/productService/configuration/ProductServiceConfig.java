package com.productService.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;

/**
 * @author  mGabellini
 */

@Configuration
@EnableRabbit
@EnableScheduling
public class ProductServiceConfig {

    @Autowired
    public ConnectionFactory rabbitConnectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(this.rabbitConnectionFactory);
        template.setMessageConverter(producerJackson2MessageConverter());
        template.setReceiveTimeout(10000);
        template.setReplyTimeout(10000);
        return template;
    }


    @Bean
    public CustomJackson2JsonMessageConverter producerJackson2MessageConverter() {
        CustomDefaultJackson2JavaTypeMapper mapper = new CustomDefaultJackson2JavaTypeMapper();
        CustomJackson2JsonMessageConverter json = new CustomJackson2JsonMessageConverter();
        json.setJavaTypeMapper(mapper);

        return json;
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new CustomDefaultClassMapper();
        return classMapper;
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }
    /**
     * Returns an Exchange for process sincronize message.
     *
     * @return the URL exchange
     * @see    DirectExchange
     */

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("rpc.exchange");
    }

    /* Product Restaurant*/

    /**
     * Returns an Queue for process message about request ProductRestaurantById.
     *
     * @return the URL Queue
     * @see    Queue
     */
    @Bean
    public Queue queueProduct() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.Product");
    }

    /**
     * Returns an Binding for process message about request ProductRestaurantByRestaurantId.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingProduct(DirectExchange exchange, @Qualifier("queueProduct") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.Product");
    }

    @Bean
    public Queue queueProductList() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.ProductList");
    }

    /**
     * Returns an Binding for process message about request ProductRestaurantByRestaurantId.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingProductProductList(DirectExchange exchange, @Qualifier("queueProductList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.ProductList");
    }

    /**
     * Returns an Queue for process message about request ProductRestaurantById.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueProductRestaurantById() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.ProductRestaurantInfo");
    }

    /**
     * Returns an Binding for process message about request ProductRestaurantByRestaurantId.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingProductRestaurantById(DirectExchange exchange, @Qualifier("queueProductRestaurantById") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.ProductRestaurantInfo");
    }


    /**
     * Returns an Queue for process message about request ProductRestaurantByRestaurantId.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueProductRestaurantList() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.ProductRestaurantList");
    }

    /**
     * Returns an Binding for process message about request ProductRestaurantByRestaurantId.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingProductRestaurant(DirectExchange exchange, @Qualifier("queueProductRestaurantList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.ProductRestaurantList");
    }




    /**
     * Returns an Queue for process message about request ProductRestaurantByRestaurantId.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueProductRestaurantByRestaurantCode() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.ProductRestaurantByRestaurantCode");
    }

    /**
     * Returns an Binding for process message about request ProductRestaurantByRestaurantCode.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingProductRestaurantByRestaurantCode(DirectExchange exchange, @Qualifier("queueProductRestaurantByRestaurantCode") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.ProductRestaurantByRestaurantCode");
    }



    /**
     * Returns an Queue for process message about request AddProductRestaurant.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueAddProduct() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.AddProduct");
    }

    /**
     * Returns an Binding for process message about request AddProductRestaurant.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingAddProduct(DirectExchange exchange, @Qualifier("queueAddProduct") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.AddProduct");
    }



    /**
     * Returns an Queue for process message about request UpdateProduct.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueUpdateProduct() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.UpdateProduct");
    }

    /**
     * Returns an Binding for process message about request UpdateProduct.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingUpdateProduct(DirectExchange exchange, @Qualifier("queueUpdateProduct") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.UpdateProduct");
    }




    /**
     * Returns an Queue for process message about request DeleteProduct.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueDeleteProduct() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.DeleteProduct");
    }

    /**
     * Returns an Binding for process message about request DeleteProduct.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingDeleteProduct(DirectExchange exchange, @Qualifier("queueDeleteProduct") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.DeleteProduct");
    }

    /**
     * Returns an Queue for process message about request AddProductRestaurant.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueAddProductRestaurant() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.AddProductRestaurant");
    }

    /**
     * Returns an Binding for process message about request AddProductRestaurant.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingAddProductRestaurant(DirectExchange exchange, @Qualifier("queueAddProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.AddProductRestaurant");
    }

    /**
     * Returns an Queue for process message about request UpdateProductRestaurant.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueUpdateProductRestaurant() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.UpdateProductRestaurant");
    }

    /**
     * Returns an Binding for process message about request UpdateProductRestaurant.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingUpdateProductRestaurant(DirectExchange exchange, @Qualifier("queueUpdateProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.UpdateProductRestaurant");
    }

    /**
     * Returns an Queue for process message about request DeleteProductRestaurant.
     *
     * @return the URL Queue
     * @see    Queue
     */

    @Bean
    public Queue queueDeleteProductRestaurant() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.DeleteProductRestaurant");
    }

    /**
     * Returns an Binding for process message about request DeleteProductRestaurant.
     *
     * @param exchange
     * @param queue
     * @return the URL Binding
     * @see    Binding
     */

    @Bean
    public Binding bindingDeleteProductRestaurant(DirectExchange exchange, @Qualifier("queueDeleteProductRestaurant") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.DeleteProductRestaurant");
    }

    /* End product Restaurant*/

    @Bean
    public Queue QueueRestaurantList() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.RestaurantList");
    }

    @Bean
    public Binding bindingRestaurantList(DirectExchange exchange, @Qualifier("QueueRestaurantList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.RestaurantList");
    }

    @Bean
    public Queue QueueCategoryList() {
        return new Queue("FDP.ProductService.MessageDirectory:Request.CategoryList");
    }

    @Bean
    public Binding bindingCategoryList(DirectExchange exchange, @Qualifier("QueueCategoryList") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("FDP.ProductService.MessageDirectory:Request.CategoryList");
    }
}