package com.mihalkovich.adminservice.dto;

import com.mihalkovich.adminservice.annotations.ValidTimeStart;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Data
public class LessonDto {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lessonTitle;

    @NotBlank
    @Size(min = 5, max = 20)
    private String teacher;

    @NotBlank
    @Size(min = 1, max = 5)
    private String auditory;

    @ValidTimeStart
    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime timeStart;

    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime duration;
}
