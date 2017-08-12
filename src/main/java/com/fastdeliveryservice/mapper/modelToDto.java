package com.fastdeliveryservice.mapper;

import com.fastdeliveryservice.model.*;
import com.fastdeliveryservice.modelTo.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

/**
 * Created by Martina on 11/08/2017.
 */
public class modelToDto {

    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        if(modelMapper == null)
            return new ModelMapper();
        else return modelMapper;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto =  modelMapper().map(user, UserDto.class);
        return userDto;
    }


}
