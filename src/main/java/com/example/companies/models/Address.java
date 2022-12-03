package com.example.companies.models;

import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Unique
    private int index;

    private String area;

    private String city;

    private String street;

    private int homeNumber;

    private int officeNumber;
}
