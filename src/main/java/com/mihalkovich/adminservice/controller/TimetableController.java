package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.TimetableDto;
import com.mihalkovich.adminservice.service.TimetableService;
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
@RequestMapping("/timetable")
@Api
public class TimetableController {

    private final TimetableService timetableService;

    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("/{course}/{group}")
    @ApiOperation(value = "get timetable")
    public List<TimetableDto> getTimetable(@PathVariable("course") String course, @PathVariable("group") String groupName){

        return timetableService.getTimetable(course, groupName);
    }

    @PutMapping
    @ApiOperation(value = "update timetable")
    public TimetableDto updateTimetable(@RequestBody @Valid TimetableDto timetableDto){

        return timetableService.updateTimetable(timetableDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete timetable")
    public TimetableDto deleteTimetable(@PathVariable String id){

        return timetableService.deleteTimetable(id);
    }

    @PostMapping
    @ApiOperation(value = "save timetable")
    public TimetableDto saveTimetable(@RequestBody @Valid TimetableDto timetableDto){

        return timetableService.saveTimetable(timetableDto);
    }
}
