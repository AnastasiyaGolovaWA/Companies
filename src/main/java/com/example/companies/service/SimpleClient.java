package com.example.companies.service;

import com.example.companies.models.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SpringClient", url = "http://localhost:8090")
public interface SimpleClient {

    @GetMapping("/find/{userId}")
    Users getUser (@PathVariable Long userId);

    @GetMapping("/hello")
    String getHello ();

    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody Users user);
}