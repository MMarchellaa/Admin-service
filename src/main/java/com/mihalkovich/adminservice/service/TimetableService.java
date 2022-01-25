package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.TimetableDto;
import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.entity.Timetable;
import com.mihalkovich.adminservice.mapper.TimetableMapper;
import com.mihalkovich.adminservice.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    private final GroupService groupService;

    private final TimetableMapper timetableMapper;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository, GroupService groupService, TimetableMapper timetableMapper) {
        this.timetableRepository = timetableRepository;
        this.groupService = groupService;
        this.timetableMapper = timetableMapper;
    }

    public List<TimetableDto> getTimetable(String course, String groupName){
        Group group = groupService.getGroup(course, groupName);

        return timetableRepository.findAllByGroup(group).orElse(new ArrayList<>())
                .stream()
                .map(timetableMapper::toDto)
                .collect(Collectors.toList());
    }

    public Timetable getSingleTimetable(Group group, String dayOfWeek){
        return timetableRepository.getTimetableByDayOfWeekAndGroup(dayOfWeek, group).orElse(new Timetable());
    }

    public TimetableDto saveTimetable(TimetableDto timetableDto){
        timetableRepository.save(timetableMapper.toTimetable(timetableDto));

        return timetableDto;
    }

    public TimetableDto deleteTimetable(TimetableDto timetableDto){
        Timetable timetable = getSingleTimetable(timetableDto.getGroup(), timetableDto.getDayOfWeek());
        timetableRepository.delete(timetable);

        return timetableDto;
    }

    public TimetableDto updateTimetable(TimetableDto timetableDtoBefore, TimetableDto timetableDtoAfter) {
        Timetable timetable = getSingleTimetable(timetableDtoBefore.getGroup(), timetableDtoBefore.getDayOfWeek());
        timetable.setGroup(timetableDtoAfter.getGroup());
        timetable.setDayOfWeek(timetableDtoAfter.getDayOfWeek());
        timetable.setLessons(timetableDtoAfter.getLessons());
        timetableRepository.save(timetable);

        return timetableDtoAfter;
    }
}
