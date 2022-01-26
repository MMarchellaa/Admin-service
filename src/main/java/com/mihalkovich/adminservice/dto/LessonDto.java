package com.mihalkovich.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.mihalkovich.adminservice.annotations.ValidTimeStart;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Data
@ApiModel
public class LessonDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    @NotBlank
    @Size(min = 3, max = 20)
    private String lessonTitle;
    @ApiModelProperty
    @NotBlank
    @Size(min = 5, max = 20)
    private String teacher;
    @ApiModelProperty
    @NotBlank
    @Size(min = 1, max = 5)
    private String auditory;

    @ValidTimeStart
    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime timeStart;

    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime duration;
}
