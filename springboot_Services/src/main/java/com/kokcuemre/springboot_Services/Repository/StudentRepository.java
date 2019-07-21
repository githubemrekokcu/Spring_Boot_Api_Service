package com.kokcuemre.springboot_Services.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kokcuemre.springboot_Services.Domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	Optional<Student> findById(Long id);

}
