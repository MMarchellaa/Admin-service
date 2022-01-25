package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.LessonDto;
import com.mihalkovich.adminservice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("lesson")
    public List<LessonDto> getAllGroups(){

        return lessonService.getAllLessons();
    }

    @PostMapping("lesson")
    public LessonDto saveLesson(@RequestBody LessonDto lessonDTO){

        return lessonService.saveLesson(lessonDTO);
    }

    @DeleteMapping("lesson/{id}")
    public LessonDto deleteLesson(@PathVariable String id){

        return lessonService.deleteLesson(id);
    }

    @PutMapping("lesson/{id}")
    public LessonDto updateLesson(@PathVariable String id, @RequestBody LessonDto lessonDto){

        return lessonService.updateLesson(id, lessonDto);
    }
}
