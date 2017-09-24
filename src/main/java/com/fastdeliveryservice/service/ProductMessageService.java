package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.IProductDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author  mGabellini
 */

@Component
public class ProductMessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

    @Autowired
    private IProductDAO productDAO;

    @Autowired
    public ProductMessageService(Environment environment,
                                 RabbitTemplate rabbitTemplate,
                                 DirectExchange directExchange) {

        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }
}