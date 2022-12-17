package com.example.companies.service;

import com.example.companies.models.Address;
import com.example.companies.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address findByAddressId(long id) {
        return addressRepository.getOne(id);
    }

}
