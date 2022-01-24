package com.mihalkovich.adminservice.controller;

import com.mihalkovich.adminservice.dto.TimetableDTO;
import com.mihalkovich.adminservice.facade.TimetableFacade;
import com.mihalkovich.adminservice.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TimetableController {

    @Autowired
    TimetableService timetableService;

    @Autowired
    TimetableFacade timetableFacade;

    @GetMapping("timetable/get/{course}/{group}")
    public List<TimetableDTO> getTimetable(@PathVariable("course") String course ,@PathVariable("group") String groupName){

        return timetableService.getTimetable(course, groupName)
                .stream()
                .map(timetableFacade::timetableToTimetableDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("timetable/update")
    public ResponseEntity<TimetableDTO> updateTimetable(@RequestBody TimetableDTO timetableDTOBefore, @RequestBody TimetableDTO timetableDTOAfter){

        TimetableDTO timetable = timetableFacade.timetableToTimetableDTO(timetableService.updateTimetable(timetableDTOBefore, timetableDTOAfter));

        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }

    @PostMapping("timetable/delete")
    public ResponseEntity<TimetableDTO> deleteTimetable(@RequestBody TimetableDTO timetableDTO){
        TimetableDTO timetable = timetableFacade.timetableToTimetableDTO(timetableService.deleteTimetable(timetableDTO));

        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }

    @PostMapping("timetable/save")
    public ResponseEntity<TimetableDTO> saveTimetable(@RequestBody TimetableDTO timetableDTO){
        TimetableDTO timetable = timetableFacade.timetableToTimetableDTO(timetableService.saveTimetable(timetableDTO));

        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }
}