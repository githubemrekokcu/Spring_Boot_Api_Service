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

import com.kokcuemre.springboot_Services.Domain.Student;
import com.kokcuemre.springboot_Services.Repository.StudentRepository;

import javassist.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping( value = "api/student")
public class StudentController {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	@GetMapping
	public ResponseEntity<List<Student>> getStudentTypes(){
		final List<Student> studentTypesList = studentRepository.findAll();
		return ResponseEntity.ok().body(studentTypesList);
	}
	
	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student){
		return ResponseEntity.ok().body(studentRepository.save(student));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Student> getById(@PathVariable(name = "id") Long id) throws NotFoundException{
		final Optional<Student> studentOptional = studentRepository.findById(id);
		if(!studentOptional.isPresent()) {
			throw new NotFoundException(Student.class.getName());
		}
		return ResponseEntity.ok().body(studentOptional.get());
	}
	
	@DeleteMapping
	public ResponseEntity<Student> deleteStudent(@RequestBody Student student){
		studentRepository.delete(student);
		return ResponseEntity.ok(student);
	}
}
