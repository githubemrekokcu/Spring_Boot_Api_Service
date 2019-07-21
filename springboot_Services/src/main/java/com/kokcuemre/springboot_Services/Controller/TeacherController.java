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

import com.kokcuemre.springboot_Services.Domain.Teacher;
import com.kokcuemre.springboot_Services.Repository.TeacherRepository;

import javassist.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {
	
	private final TeacherRepository teacherRepository;
	
	@Autowired
	public TeacherController(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@GetMapping
	public ResponseEntity<List<Teacher>> getStudentTypes(){
		final List<Teacher> studentTypesList = teacherRepository.findAll();
		return ResponseEntity.ok().body(studentTypesList);
	}
	
	@PostMapping
	public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
		return ResponseEntity.ok().body(teacherRepository.save(teacher));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Teacher> getById(@PathVariable(name = "id") Long id) throws NotFoundException{
		final Optional<Teacher> teacherOptional = teacherRepository.findById(id);
		if(!teacherOptional.isPresent()) {
			throw new NotFoundException(Teacher.class.getName());
		}
		return ResponseEntity.ok().body(teacherOptional.get());
	}
	
	@DeleteMapping
	public ResponseEntity<Teacher> deleteStudent(@RequestBody Teacher teacher){
		teacherRepository.delete(teacher);
		return ResponseEntity.ok(teacher);
	}
}
