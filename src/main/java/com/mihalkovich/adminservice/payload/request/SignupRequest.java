package com.mihalkovich.adminservice.payload.request;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String password;
}
