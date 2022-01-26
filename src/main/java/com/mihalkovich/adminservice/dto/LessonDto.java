package com.mihalkovich.adminservice.dto;

import lombok.Data;

@Data
public class LessonDto {

    private Long id;
    private String lessonTitle;
    private String teacher;
    private String auditory;
}
