package com.course.service.courseservice.services;

import java.util.List;

import com.course.service.courseservice.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public void addCourse(Course course);
	public void updateCourse(Course course);
	public void deleteCourse(int id);

}
