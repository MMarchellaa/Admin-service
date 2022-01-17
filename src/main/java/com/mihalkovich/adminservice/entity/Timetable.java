package com.mihalkovich.adminservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.temporal.WeekFields;

@Getter
@Setter
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private WeekFields dayOfWeek;

    @Column
    private Group group;

    @Column
    private int lessonNumber;

    @Column
    private String lessonTitle;
}
