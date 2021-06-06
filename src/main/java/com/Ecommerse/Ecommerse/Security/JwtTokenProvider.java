package com.Ecommerse.Ecommerse.Security;

import com.Ecommerse.Ecommerse.Domains.UserDomains.Roles;
import com.Ecommerse.Ecommerse.Service.MyUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {
    @Autowired
    UserDetailsService myUserDetailsService;

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long tokenValidityMill;


    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @PostConstruct
    protected void init()
    {
        secret= Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username, Set<Roles> roles){
        Claims claims= Jwts.claims().setSubject(username);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity=new Date(now.getTime()+tokenValidityMill);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public boolean validateToken(String token)
    {
        Jws<Claims> claimsJws=Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        if(claimsJws.getBody().getExpiration().before(new Date()))
        {
            return false;
        }

        return true;

    }

    public String resolveToken(HttpServletRequest request)
    {
        String bearerToken=request.getHeader("Authorization");
        if (bearerToken!=null&&bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7);
        }

        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(getUser(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    private String getUser(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}
