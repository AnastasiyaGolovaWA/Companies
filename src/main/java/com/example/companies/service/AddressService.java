package com.example.companies.service;

import com.example.companies.models.Address;
import com.example.companies.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public boolean findByAddressId(long id) {
        return addressRepository.findById(id).isPresent();
    }

}
