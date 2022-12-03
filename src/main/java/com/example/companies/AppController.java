package com.example.companies;

import com.example.companies.models.Users;
import com.example.companies.service.SimpleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final SimpleClient client;

    @GetMapping("/find/{userId}")
    public Users getUser(@PathVariable Long userId) {
        return client.getUser(userId);
    }

    @GetMapping("/hello")
    public String getHello() {
        return client.getHello();
    }

    @GetMapping("/signin")
    ResponseEntity<?> signin(@RequestBody Users userDTO) {
        return client.signin(userDTO);
    }
}