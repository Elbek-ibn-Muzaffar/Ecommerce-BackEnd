package com.Ecommerse.Ecommerse.Controller;

import com.Ecommerse.Ecommerse.Domains.Company;
import com.Ecommerse.Ecommerse.Dto.CompanyDto;
import com.Ecommerse.Ecommerse.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("/admin/addCompany")
    public ResponseEntity saveCompany(@RequestBody CompanyDto companyDto)
    {
        Company company=companyService.saveCompany(companyDto);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/admin/getAllCompany")
    public ResponseEntity getAllCompany()
    {
        List<Company> companies=companyService.getAllCompany();
        return ResponseEntity.ok(companies);
    }
}
