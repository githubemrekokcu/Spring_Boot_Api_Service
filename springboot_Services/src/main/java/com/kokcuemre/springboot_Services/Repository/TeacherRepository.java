package com.kokcuemre.springboot_Services.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kokcuemre.springboot_Services.Domain.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	List<Teacher> findAll();
	Optional<Teacher> findById(Long id);
}
