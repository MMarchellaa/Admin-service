package com.mihalkovich.adminservice.dto;

import com.mihalkovich.adminservice.entity.Group;
import lombok.Data;

import java.util.List;

@Data
public class TimetableDTO {

    private String dayOfWeek;
    private Group group;
    private List<LessonDTO> lessons;

}
