package com.mihalkovich.adminservice.mapper;

import com.mihalkovich.adminservice.dto.TimetableDto;
import com.mihalkovich.adminservice.entity.Timetable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimetableMapper {

    TimetableDto timetableToTimetableDto(Timetable timetable);
}
