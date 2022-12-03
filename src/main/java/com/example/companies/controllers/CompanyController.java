package com.example.companies.controllers;

import com.example.companies.models.Company;
import com.example.companies.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/companies")
@RestController
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/{companyId}")
    public boolean findById(@PathVariable("companyId") long companyId) {
        return companyService.findByCompanyId(companyId).isPresent();
    }

    @GetMapping(path = "/all")
    public List<Company> getAll() {
        return companyService.getAll();
    }
}
