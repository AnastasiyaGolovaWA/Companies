package com.example.companies.repository;

import com.example.companies.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE companies SET deleted = true WHERE company_id = :id", nativeQuery = true)
    void updateCompanyDeleted(Integer id);

}