package com.mihalkovich.adminservice.repository;

import com.mihalkovich.adminservice.entity.Group;
import com.mihalkovich.adminservice.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    Optional<List<Timetable>> findAllByGroup(Group group);

    Optional<Timetable> getTimetableByDayOfWeekAndGroup(String dayOfWeek, Group group);
}
