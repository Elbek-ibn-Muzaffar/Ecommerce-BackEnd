package com.Ecommerse.Ecommerse.Converter;


import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    ModelMapper mapper=new ModelMapper();

    public Users dtoToEntity(UserDto userDto)
    {
        Users users=mapper.map(userDto,Users.class);
        return users;
    }

}
