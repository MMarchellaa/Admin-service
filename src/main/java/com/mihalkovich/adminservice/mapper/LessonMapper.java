package com.mihalkovich.adminservice.mapper;

import com.mihalkovich.adminservice.dto.LessonDto;
import com.mihalkovich.adminservice.entity.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toLesson(LessonDto lessonDto);

    LessonDto toDto(Lesson lesson);
}
