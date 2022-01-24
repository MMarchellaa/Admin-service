package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.LessonDTO;
import com.mihalkovich.adminservice.facade.LessonFacade;
import com.mihalkovich.adminservice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    LessonService lessonService;

    @Autowired
    LessonFacade lessonFacade;

    @GetMapping("lesson/all")
    public ResponseEntity<List<LessonDTO>> getAllGroups(){
        List<LessonDTO> allLessonsDTO = lessonService.getAllLessons();

        return new ResponseEntity<>(allLessonsDTO, HttpStatus.OK);
    }

    @PostMapping("lesson/save")
    public ResponseEntity<LessonDTO> updateTimetable(@RequestBody LessonDTO lessonDTO){
        LessonDTO lesson = lessonFacade.lessonToLessonDTO(lessonService.saveLesson(lessonDTO));

        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @PostMapping("lesson/delete")
    public ResponseEntity<LessonDTO> deleteLesson(@RequestBody LessonDTO lessonDTO){
        LessonDTO lesson = lessonFacade.lessonToLessonDTO(lessonService.deleteLesson(lessonDTO));

        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @PostMapping("group/update")
    public ResponseEntity<LessonDTO> updateLesson(@RequestBody LessonDTO lessonDTOBefore, @RequestBody LessonDTO lessonDTOAfter){
        LessonDTO lesson = lessonFacade.lessonToLessonDTO(lessonService.updateLesson(lessonDTOBefore, lessonDTOAfter));

        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }
}