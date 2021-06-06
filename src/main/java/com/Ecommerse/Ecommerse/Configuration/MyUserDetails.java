package com.Ecommerse.Ecommerse.Configuration;


import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import com.Ecommerse.Ecommerse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String userName;


    @Autowired
    UserRepository userRepository;

    public MyUserDetails(String userName){
        this.userName=userName;
    }

    public MyUserDetails()
    {

    }

    Users users=userRepository.findByName(userName);

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  users.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }



    @Override
    public String getUsername() {
        return users.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
