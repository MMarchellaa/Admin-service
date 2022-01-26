package com.mihalkovich.adminservice.dto;

import com.mihalkovich.adminservice.entity.Group;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@ApiModel
public class TimetableDto {

    @ApiModelProperty
    private Long id;
    @NotBlank
    @ApiModelProperty
    private String dayOfWeek;
    @Valid
    private GroupDto group;
    @Valid
    @ApiModelProperty
    private Group group;
    @ApiModelProperty
    private List<LessonDto> lessons;

}
