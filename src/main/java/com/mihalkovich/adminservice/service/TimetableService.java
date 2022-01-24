package com.mihalkovich.adminservice.service;

import com.mihalkovich.adminservice.dto.TimetableDTO;
import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.entity.Timetable;
import com.mihalkovich.adminservice.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private GroupService groupService;

    public List<Timetable> getTimetable(String course, String groupName){
        Group group = groupService.getGroup(course, groupName);

        return timetableRepository.findAllByGroup(group).orElse(new ArrayList<>());
    }

    public Timetable getSingleTimetable(Group group, String dayOfWeek){
        return timetableRepository.getTimetableByDayOfWeekAndGroup(dayOfWeek, group).orElse(new Timetable());
    }

    public Timetable saveTimetable(TimetableDTO timetableDTO){
        Timetable timetable = new Timetable(timetableDTO.getDayOfWeek(), timetableDTO.getGroup(), timetableDTO.getLessonsQuery());

        return timetableRepository.save(timetable);
    }

    public Timetable deleteTimetable(TimetableDTO timetableDTO){
        Timetable timetable = getSingleTimetable(timetableDTO.getGroup(), timetableDTO.getDayOfWeek());
        timetableRepository.delete(timetable);

        return timetable;
    }

    public Timetable updateTimetable(TimetableDTO timetableDTOBefore, TimetableDTO timetableDTOAfter) {
        Timetable timetable = getSingleTimetable(timetableDTOBefore.getGroup(), timetableDTOBefore.getDayOfWeek());
        timetable.setGroup(timetableDTOAfter.getGroup());
        timetable.setDayOfWeek(timetableDTOAfter.getDayOfWeek());
        timetable.setLessonsQuery(timetableDTOAfter.getLessonsQuery());

        return timetableRepository.save(timetable);
    }
}