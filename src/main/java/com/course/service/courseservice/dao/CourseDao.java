package com.course.service.courseservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.service.courseservice.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
