package com.mihalkovich.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class UserDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    @NotBlank
    @Size(min = 6, max = 20)
    private String username;
    @ApiModelProperty
    private String role;
}
