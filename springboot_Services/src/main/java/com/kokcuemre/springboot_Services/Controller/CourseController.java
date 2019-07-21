package com.kokcuemre.springboot_Services.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kokcuemre.springboot_Services.Domain.Course;
import com.kokcuemre.springboot_Services.Repository.CourseRepository;

import javassist.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "api/course")
public class CourseController {
	
	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping
	public ResponseEntity<List<Course>> getCourseTypes(){
		final List<Course> courseTypesList = courseRepository.findAll();
		return ResponseEntity.ok().body(courseTypesList);
	}
	
	@PostMapping
	public ResponseEntity<Course> save(@RequestBody Course course){
		return ResponseEntity.ok().body(courseRepository.save(course));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Course> getById(@PathVariable(name = "id") Long id) throws NotFoundException {
		final Optional<Course> courseOptional = courseRepository.findById(id);
		if(!courseOptional.isPresent()) {
			throw new NotFoundException(Course.class.getName());
		}
		return ResponseEntity.ok().body(courseOptional.get());
	}
	
	@DeleteMapping
	public ResponseEntity<Course> daleteCourse(@RequestBody Course course){
		courseRepository.delete(course);
		return ResponseEntity.ok(course);
	}
}
