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

    public LessonDto deleteLesson(String id){
        Lesson lesson = lessonRepository.findLessonById(Long.parseLong(id));
        lessonRepository.delete(lesson);

        return lessonMapper.toDto(lesson);
    }

    public LessonDto updateLesson(LessonDto lessonDto) {
        Lesson lesson = lessonRepository.findLessonById(lessonDto.getId());
        lesson.setTeacher(lessonDto.getTeacher());
        lesson.setLessonTitle(lessonDto.getLessonTitle());
        lesson.setAuditory(lessonDto.getAuditory());
        lesson.setTimeStart(lessonDto.getTimeStart());
        lesson.setDuration(lessonDto.getDuration());
        lessonRepository.save(lesson);

        return lessonMapper.toDto(lesson);
    }
}
