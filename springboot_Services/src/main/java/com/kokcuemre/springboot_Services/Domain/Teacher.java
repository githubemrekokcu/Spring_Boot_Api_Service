package com.kokcuemre.springboot_Services.Domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private Long id;
	@Column(name = "teacher_first_name")
	private String teacherFirstName;
	@Column(name = "teacher_last_name")
	private String teacherLastName;
	@Column(name = "teacher_birth_of_date")
	private Date teacherBirthOfDate;
	@Column(name = "teacher_email")
	private String teacherEmail;
	@Column(name = "teacher_tel")
	private String teacherTel;
	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "course_fk_id", nullable = false)
	private Course course;

}
