package com.course.service.courseservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.service.courseservice.dao.CourseDao;
import com.course.service.courseservice.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	private List<Course> courseList=new ArrayList<Course>();
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		this.courseList=this.courseDao.findAll();
		return this.courseList;
	}

	@Override
	public void addCourse(Course course) {
		this.courseDao.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		this.courseDao.save(course);
		
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		this.courseDao.deleteById(id);
	}

}
