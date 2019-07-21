package com.kokcuemre.springboot_Services.Domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	@Column(name = "student_first_name")
	private String studentFirstName;
	@Column(name = "student_last_name")
	private String studentLastName;
	@Column(name = "student_birth_of_date")
	private Date studentBirthOfDate;
	@Column(name = "student_email")
	private String studentEmail;
	@Column(name = "student_tel")
	private String studentTel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course_fk_id")
	private Course course;
}
