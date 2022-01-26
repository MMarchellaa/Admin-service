package com.mihalkovich.adminservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id;

    @NotBlank
    @Size(min = 6, max = 20)
    private String username;
    private String role;
}
