package com.mihalkovich.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@ApiModel(description = "Data transfer object for timetable entity")
public class TimetableDto {

    @ApiModelProperty(name = "Identifier")
    private Long id;
    @NotBlank
    @ApiModelProperty(name = "The day of week")
    private String dayOfWeek;
    @Valid
    @ApiModelProperty(name = "The group entity")
    private GroupDto group;
    @ApiModelProperty(name = "Lessons, that will be on the dayOfWeek day")
    private List<LessonDto> lessons;

}
