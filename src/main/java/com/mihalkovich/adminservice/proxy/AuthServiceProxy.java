package com.mihalkovich.adminservice.proxy;

import com.mihalkovich.adminservice.payload.request.LoginRequest;
import com.mihalkovich.adminservice.payload.request.SignupRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-gateway")
public interface AuthServiceProxy {
    @PostMapping("/auth-service/signin")
    ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest);

    @PostMapping("/auth-service/signup")
    ResponseEntity<Object> registerUser(@RequestBody SignupRequest signupRequest);
}
