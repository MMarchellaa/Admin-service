package com.mihalkovich.adminservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GroupDto {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 10)
    private String group;

    @NotBlank
    @Size(min = 1, max = 15)
    private String course;
}
