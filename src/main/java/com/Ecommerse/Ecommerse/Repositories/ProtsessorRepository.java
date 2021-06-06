package com.Ecommerse.Ecommerse.Repositories;

import com.Ecommerse.Ecommerse.Domains.Protsessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtsessorRepository extends JpaRepository<Protsessor,Long> {
    Protsessor findById(long id);
}
