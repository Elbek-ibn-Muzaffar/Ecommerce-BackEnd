package com.Ecommerse.Ecommerse.Service;

import com.Ecommerse.Ecommerse.Converter.UserConverter;
import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Dto.UserDto;
import com.Ecommerse.Ecommerse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserConverter userConverter=new UserConverter();
    @Autowired
    private UserRepository userRepository;

    public Users saveUser(UserDto userDto)
    {
        Users users=userConverter.dtoToEntity(userDto);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public boolean checkEmail(String email)
    {

       return userRepository.existsByEmail(email);
    }

    public Users findByUsername(String name)
    {
        return userRepository.findByName(name);
    }

    @Autowired
    PasswordEncoder passwordEncoder;
}
