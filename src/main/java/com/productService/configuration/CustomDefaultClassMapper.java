package com.productService.configuration;

import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Martina on 27/09/2017.
 */
    @Configuration
    public class CustomDefaultClassMapper extends DefaultClassMapper {

    @Override
    public String getClassIdFieldName() {
        return "type";
    }

}
