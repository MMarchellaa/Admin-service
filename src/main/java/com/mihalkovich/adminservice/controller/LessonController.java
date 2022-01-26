package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.LessonDto;
import com.mihalkovich.adminservice.service.LessonService;
import io.swagger.annotations.Api;
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

import java.util.List;

@RestController
@RequestMapping("/lesson")
@Api
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    @ApiOperation(value = "get all lessons")
    public List<LessonDto> getAllLessons(){

        return lessonService.getAllLessons();
    }

    @PostMapping
    @ApiOperation(value = "save lesson")
    public LessonDto saveLesson(@RequestBody @Valid LessonDto lessonDto){

        return lessonService.saveLesson(lessonDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete lesson")
    public LessonDto deleteLesson(@PathVariable String id){

        return lessonService.deleteLesson(id);
    }

    @PutMapping
    @ApiOperation(value = "update lesson")
    public LessonDto updateLesson(@RequestBody @Valid LessonDto lessonDto){

        return lessonService.updateLesson(lessonDto);
    }
}
