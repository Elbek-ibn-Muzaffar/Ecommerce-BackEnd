package com.Ecommerse.Ecommerse.Controller;

import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Security.SecurityUtils;
import com.Ecommerse.Ecommerse.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountController {
    @Autowired
    private UserService userService;

//    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "http://localhost:8080")
    @GetMapping("/account")
    public ResponseEntity getAccount(){
        String login = SecurityUtils.getCurrentUsername().get();
        Users users=userService.findByUsername(login);
        return ResponseEntity.ok(users);
    }
}
