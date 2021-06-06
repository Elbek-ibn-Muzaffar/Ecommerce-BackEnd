package com.Ecommerse.Ecommerse.Controller;



import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Dto.LoginDto;
import com.Ecommerse.Ecommerse.Repositories.UserRepository;
import com.Ecommerse.Ecommerse.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
//@ResponseBody
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

//    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/enters")
    public ResponseEntity login(@RequestBody LoginDto loginDto)
    {

        Users users=userRepository.findByName(loginDto.getUsername());
        if(users==null)
        {
            throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas");

        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));

//        else if (users.getPassword()!=loginDto.getPassword()){
//            throw new UsernameNotFoundException("Parol notug'ri kiritildi");
//        }



        String token=jwtTokenProvider.createToken(users.getName(),users.getRoles());
        Map<Object,Object> map=new HashMap<>();
        map.put("username",users.getName());
        map.put("token",token);
        return ResponseEntity.ok(map);
    }
}
