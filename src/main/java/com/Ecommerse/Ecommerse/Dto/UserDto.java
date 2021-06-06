package com.Ecommerse.Ecommerse.Dto;

import com.Ecommerse.Ecommerse.Domains.Enurmations.UserStatus;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {


    private long id;
    private String name;

    private String password;

    private String email;

    private UserStatus userStatus;

    private Set<RoleDto> roles;

    public String getEmail() {
        return email;
    }
}
