package com.Ecommerse.Ecommerse.Repositories;


import com.Ecommerse.Ecommerse.Domains.UserDomains.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);
    boolean existsByEmail(String email);
}
