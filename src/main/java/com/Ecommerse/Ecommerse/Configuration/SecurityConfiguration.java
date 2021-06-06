package com.Ecommerse.Ecommerse.Configuration;

import com.Ecommerse.Ecommerse.Security.JwtTokenConfigurer;
import com.Ecommerse.Ecommerse.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Autowired
//    private AuthenticationManager authenticationManager;



    @Bean
    public AuthenticationManager authenticationManager() throws Exception
    {
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/enters").permitAll()
                .antMatchers("/addUser").permitAll()
                .antMatchers("/getOneKomputer").permitAll()
                .antMatchers("/preview/**").permitAll()
                .antMatchers("/getAllProductNotebooks").permitAll()
                .antMatchers("/getAllProductDesctop").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")

                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .apply(new JwtTokenConfigurer(jwtTokenProvider));

    }





}
