package com.mihalkovich.adminservice.facade;

import com.mihalkovich.adminservice.dto.LessonDTO;
import com.mihalkovich.adminservice.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonFacade {

    public LessonDTO lessonToLessonDTO(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setLessonTitle(lesson.getLessonTitle());
        lessonDTO.setTeacher(lesson.getTeacher());
        lessonDTO.setAuditory(lesson.getAuditory());

        return lessonDTO;
    }
}
