package com.fastdeliveryservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Martina on 31/07/2017.
 */

@Configuration
public class LocationConfig {

    /**
     * Used for RPC IPC example
     *
     * @return
     */

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("location.rpc");
    }

    /**
     * Used for eventually consistent example
     *
     * @return
     */
    @Bean
    public Queue locationQueue() {
        return new Queue("locations.queue");
    }

    /**
     * Used for RPC IPC example
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("location.rpc.requests");
    }

    /**
     * Used for RPC IPC example
     *
     * @return
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("location.rpc");
    }

    /**
     * Used for RPC IPC example
     *
     * @return
     */
    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("rpc");
    }


//    }
}