package com.mihalkovich.adminservice.facade;

import com.mihalkovich.adminservice.dto.TimetableDTO;
import com.mihalkovich.adminservice.entity.Timetable;
import org.springframework.stereotype.Component;

@Component
public class TimetableFacade {

    public TimetableDTO timetableToTimetableDTO(Timetable timetable){
        TimetableDTO timetableDTO = new TimetableDTO();
        timetableDTO.setGroup(timetable.getGroup());
        timetableDTO.setLessonsQuery(timetable.getLessonsQuery());
        timetableDTO.setDayOfWeek(timetable.getDayOfWeek());

        return timetableDTO;
    }
}
