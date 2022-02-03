package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.LessonDto;
import com.mihalkovich.adminservice.service.LessonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/lesson")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    @ApiOperation(value = "Get all lessons")
    public List<LessonDto> getAllLessons(){

        return lessonService.getAllLessons();
    }

    @PostMapping
    @ApiOperation(value = "Save the lesson")
    public LessonDto saveLesson(@RequestBody @Valid LessonDto lessonDto){

        return lessonService.saveLesson(lessonDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete lesson")
    public LessonDto deleteLesson(@PathVariable String id){

        return lessonService.deleteLesson(id);
    }

    @PutMapping
    @ApiOperation(value = "Update lesson")
    public LessonDto updateLesson(@RequestBody @Valid LessonDto lessonDto){

        return lessonService.updateLesson(lessonDto);
    }
}
