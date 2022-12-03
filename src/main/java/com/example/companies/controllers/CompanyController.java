package com.example.companies.controllers;

import com.example.companies.AppController;
import com.example.companies.models.Company;
import com.example.companies.service.AddressService;
import com.example.companies.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/companies")
@RestController
public class CompanyController {
    private CompanyService companyService;

    private AppController appController;

    private AddressService addressService;

    @Autowired
    public void setAppController(AppController appController) {
        this.appController = appController;
    }
    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/{companyId}")
    public boolean findById(@PathVariable("companyId") long companyId) {
        return companyService.findByCompanyId(companyId).isPresent();
    }

    @GetMapping(path = "/all")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createCompany(@RequestBody Company company) {
        Company companyNew = new Company();
        companyNew.setName(company.getName());
        companyNew.setOgrn(company.getOgrn());
        companyNew.setShortName(company.getShortName());
        //if (addressService.findByAddressId(company.getAddress().getAddressId())) {
            companyNew.setAddress(company.getAddress());
        /*}
        else {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }*/
        if (appController.findById(company.getUserId())) {
            companyNew.setUserId(company.getUserId());
        }
        else {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        companyService.save(company);
        return ResponseEntity.ok(company);
    }
}
