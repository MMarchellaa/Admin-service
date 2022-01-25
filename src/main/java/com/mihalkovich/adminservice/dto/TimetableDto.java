package com.mihalkovich.adminservice.dto;

import com.mihalkovich.adminservice.entity.Group;
import lombok.Data;

import java.util.List;

@Data
public class TimetableDto {

    private Long id;
    private String dayOfWeek;
    private Group group;
    private List<LessonDto> lessons;

}
