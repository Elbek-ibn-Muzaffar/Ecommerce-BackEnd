package com.Ecommerse.Ecommerse.Repositories;

import com.Ecommerse.Ecommerse.Domains.Texnika;
import jdk.internal.jline.internal.TestAccessible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TexnikaRepository extends JpaRepository<Texnika,Long> {
    Texnika findById(long id);
}
