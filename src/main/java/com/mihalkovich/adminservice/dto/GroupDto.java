package com.mihalkovich.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel(description = "Data transfer object for group entity")
public class GroupDto {

    @ApiModelProperty(name = "Identifier")
    private Long id;
    @ApiModelProperty(name = "Group name")
    @NotBlank
    @Size(min = 1, max = 10)
    private String group;
    @ApiModelProperty(name = "Number of the course")
    @NotBlank
    @Size(min = 1, max = 15)
    private String course;
}
