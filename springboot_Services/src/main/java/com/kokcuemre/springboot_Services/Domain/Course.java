package com.kokcuemre.springboot_Services.Domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long id;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "course_start_date")
	private Date courseStartDate;
	@Column(name="course_end_date")
	private Date courseEndDate;	
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "course")
	private Teacher teacher;
}
