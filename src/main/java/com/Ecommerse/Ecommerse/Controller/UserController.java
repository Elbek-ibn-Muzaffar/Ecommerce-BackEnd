package com.Ecommerse.Ecommerse.Controller;



import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Dto.UserDto;
import com.Ecommerse.Ecommerse.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;



    @PostMapping("/addUser")
    public ResponseEntity saveUsers(@RequestBody UserDto userDto)
    {
        if(userService.checkEmail(userDto.getEmail()))
        {
            return new ResponseEntity("Bu user Mavjud", HttpStatus.BAD_REQUEST);
        }
        Users users=userService.saveUser(userDto);
        return ResponseEntity.ok(users);
    }
}
