package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.LessonDto;
import com.mihalkovich.adminservice.entity.Lesson;
import com.mihalkovich.adminservice.mapper.LessonMapper;
import com.mihalkovich.adminservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    private final LessonMapper lessonMapper;

    @Autowired
    public LessonService(LessonRepository lessonRepository, LessonMapper lessonMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
    }

    public LessonDto saveLesson(LessonDto lessonDto){
        lessonRepository.save(lessonMapper.toLesson(lessonDto));

        return lessonDto;
    }

    public List<LessonDto> getAllLessons(){
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    public Lesson getLesson(String teacher, String lessonTitle, String auditory){
        return lessonRepository.findLessonByTeacherAndLessonTitleAndAuditory(teacher, lessonTitle, auditory).orElseThrow();
    }

    public LessonDto deleteLesson(LessonDto lessonDto){
        Lesson lesson = getLesson(lessonDto.getTeacher(), lessonDto.getLessonTitle(), lessonDto.getAuditory());
        lessonRepository.delete(lesson);

        return lessonDto;
    }

    public LessonDto updateLesson(LessonDto lessonDtoBefore, LessonDto lessonDtoAfter) {
        Lesson lesson = getLesson(lessonDtoBefore.getTeacher(), lessonDtoBefore.getLessonTitle(), lessonDtoBefore.getAuditory());
        lesson.setTeacher(lessonDtoAfter.getTeacher());
        lesson.setLessonTitle(lessonDtoAfter.getLessonTitle());
        lesson.setAuditory(lessonDtoAfter.getAuditory());
        lessonRepository.save(lesson);

        return lessonDtoAfter;
    }
}
