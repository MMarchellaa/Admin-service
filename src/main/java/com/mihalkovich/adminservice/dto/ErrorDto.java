package com.mihalkovich.adminservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ErrorDto {
    private String code;
    private String message;
    private Map<String, String> errors;
}
