package com.course.service.courseservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	private int Id;
	private String courseName;
	private String courseDesc;
	
	public Course() {}

	public Course(int id, String courseName, String courseDesc) {
		Id = id;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	@Override
	public String toString() {
		return "Course [Id=" + Id + ", courseName=" + courseName + ", courseDesc=" + courseDesc + "]";
	};
	
	

}
