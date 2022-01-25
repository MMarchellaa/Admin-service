package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.TimetableDto;
import com.mihalkovich.adminservice.service.TimetableService;
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
public class TimetableController {

    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("timetable/{course}/{group}")
    public List<TimetableDto> getTimetable(@PathVariable("course") String course , @PathVariable("group") String groupName){

        return timetableService.getTimetable(course, groupName);
    }

    @PutMapping("timetable")
    public TimetableDto updateTimetable(@RequestBody TimetableDto timetableDtoBefore, @RequestBody TimetableDto timetableDtoAfter){

        return timetableService.updateTimetable(timetableDtoBefore, timetableDtoAfter);
    }

    @DeleteMapping("timetable")
    public TimetableDto deleteTimetable(@RequestBody TimetableDto timetableDTO){

        return timetableService.deleteTimetable(timetableDTO);
    }

    @PostMapping("timetable")
    public TimetableDto saveTimetable(@RequestBody TimetableDto timetableDTO){

        return timetableService.saveTimetable(timetableDTO);
    }
}
