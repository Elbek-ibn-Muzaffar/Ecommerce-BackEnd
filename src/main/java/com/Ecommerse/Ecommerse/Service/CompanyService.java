package com.Ecommerse.Ecommerse.Service;

import com.Ecommerse.Ecommerse.Converter.Converters;
import com.Ecommerse.Ecommerse.Domains.Company;
import com.Ecommerse.Ecommerse.Dto.CompanyDto;
import com.Ecommerse.Ecommerse.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    Converters converters=new Converters();

    public Company saveCompany(CompanyDto companyDto)
    {
        Company company=converters.dtoToEntityCompany(companyDto);
        return companyRepository.save(company);
    }

    public List<Company> getAllCompany()
    {
        return companyRepository.findAll();
    }
}
