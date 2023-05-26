package com.course.service.courseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.courseservice.entity.Course;
import com.course.service.courseservice.services.CourseService;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	CourseService courseService;
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> home() {
		List<Course> courseList= courseService.getCourses();
		System.out.println("List size: "+courseList.size());
		if(courseList.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course){
		
		Course obj=course;
		try {
				System.out.println("Course to  be added: "+obj);
				courseService.addCourse(course);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully added");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
	}
	
	@PutMapping("/updatecourse")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
		try {
			
			this.courseService.updateCourse(course);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("course updated successfully");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId){
		try {
			int id=Integer.parseInt(courseId);
			this.courseService.deleteCourse(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted successfully");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
