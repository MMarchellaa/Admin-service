package com.mihalkovich.adminservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "study_schedule")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dayOfWeek;

    @OneToOne
    private Group group;

    @ManyToMany
    private List<Lesson> lessons;

    public Timetable(String dayOfWeek, Group group, List<Lesson> lessons) {
        this.dayOfWeek = dayOfWeek;
        this.group = group;
        this.lessons = lessons;
    }
}
