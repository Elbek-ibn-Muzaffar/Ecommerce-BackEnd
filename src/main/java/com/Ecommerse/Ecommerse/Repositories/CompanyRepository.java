package com.Ecommerse.Ecommerse.Repositories;

import com.Ecommerse.Ecommerse.Domains.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findById(long id);
}
