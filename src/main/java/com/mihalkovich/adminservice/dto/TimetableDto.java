package com.mihalkovich.adminservice.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class TimetableDto {

    private Long id;

    @NotBlank
    private String dayOfWeek;
    @Valid
    private GroupDto group;
    @Valid
    private List<LessonDto> lessons;

}
