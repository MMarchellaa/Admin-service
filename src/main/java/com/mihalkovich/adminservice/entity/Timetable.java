package com.mihalkovich.adminservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dayOfWeek;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Group group;

    @Column
    private int lessonNumber;

    @Column
    private String lessonTitle;
}
