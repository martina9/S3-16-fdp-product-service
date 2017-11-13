package com.productService.configuration;

import org.springframework.amqp.support.converter.DefaultClassMapper;

import org.springframework.context.annotation.Configuration;

/**
 * @author  mGabellini
 */

    @Configuration
    public class CustomDefaultClassMapper extends DefaultClassMapper {

    @Override
    public String getClassIdFieldName() {
        return "type";
    }
}
