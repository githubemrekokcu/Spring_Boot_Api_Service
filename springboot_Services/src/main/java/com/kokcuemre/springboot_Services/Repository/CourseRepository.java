package com.kokcuemre.springboot_Services.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kokcuemre.springboot_Services.Domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	Optional<Course> findById(Long id);
}
