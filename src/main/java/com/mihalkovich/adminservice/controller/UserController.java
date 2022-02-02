package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.payload.request.LoginRequest;
import com.mihalkovich.adminservice.payload.request.SignupRequest;
import com.mihalkovich.adminservice.proxy.AuthServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthServiceProxy proxy;

    @Autowired
    public UserController(AuthServiceProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);

        return proxy.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody SignupRequest signupRequest) {
        System.out.println("method");

        return proxy.registerUser(signupRequest);
    }
}
