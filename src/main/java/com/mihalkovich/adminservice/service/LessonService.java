package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.LessonDTO;
import com.mihalkovich.adminservice.entity.Lesson;
import com.mihalkovich.adminservice.facade.LessonFacade;
import com.mihalkovich.adminservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private LessonFacade lessonFacade;

    public Lesson saveLesson(LessonDTO lessonDTO){

        Lesson lesson = new Lesson();
        lesson.setLessonTitle(lessonDTO.getLessonTitle());
        lesson.setAuditory(lessonDTO.getAuditory());
        lesson.setTeacher(lessonDTO.getTeacher());

        return lessonRepository.save(lesson);
    }

    public List<LessonDTO> getAllLessons(){
        return lessonRepository.findAll().stream()
                .map(lessonFacade::lessonToLessonDTO)
                .collect(Collectors.toList());
    }

    public Lesson getLesson(String teacher, String lessonTitle, String auditory){
        return lessonRepository.findLessonByTeacherAndLessonTitleAndAuditory(teacher, lessonTitle, auditory).orElseThrow();
    }

    public Lesson deleteLesson(LessonDTO lessonDTO){
        Lesson lesson = getLesson(lessonDTO.getTeacher(), lessonDTO.getLessonTitle(), lessonDTO.getAuditory());
        lessonRepository.delete(lesson);

        return lesson;
    }

    public Lesson updateLesson(LessonDTO lessonDTOBefore, LessonDTO lessonDTOAfter) {
        Lesson lesson = getLesson(lessonDTOBefore.getTeacher(), lessonDTOBefore.getLessonTitle(), lessonDTOBefore.getAuditory());
        lesson.setTeacher(lessonDTOAfter.getTeacher());
        lesson.setLessonTitle(lessonDTOAfter.getLessonTitle());
        lesson.setAuditory(lessonDTOAfter.getAuditory());
        lessonRepository.save(lesson);

        return lesson;
    }
}