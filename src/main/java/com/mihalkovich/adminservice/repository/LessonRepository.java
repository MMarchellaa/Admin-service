package com.mihalkovich.adminservice.repository;

import com.mihalkovich.adminservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findLessonByTeacherAndLessonTitleAndAuditory(String teacher, String lessonTitle, String auditory);
    Lesson findLessonById(Long id);

}
