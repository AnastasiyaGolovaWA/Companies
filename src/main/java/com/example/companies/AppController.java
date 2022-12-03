package com.example.companies;

import com.example.companies.models.Users;
import com.example.companies.service.SimpleClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final SimpleClient client;

    @GetMapping("/users/find/{userId}")
    public Users getUser(@PathVariable Long userId) {
        return client.getUser(userId);
    }

    @GetMapping("/users/hello")
    public String getHello() {
        return client.getHello();
    }

    @PostMapping("/users/signin")
    ResponseEntity<?> signin(@RequestBody Users userDTO) {
        return client.signin(userDTO);
    }
}