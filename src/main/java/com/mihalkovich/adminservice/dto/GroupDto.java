package com.mihalkovich.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class GroupDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty

    @NotBlank
    @Size(min = 1, max = 10)
    private String group;
    @ApiModelProperty

    @NotBlank
    @Size(min = 1, max = 15)
    private String course;
}
