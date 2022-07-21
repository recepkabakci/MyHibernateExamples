package com.bilgeadam.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="teacher_id", referencedColumnName = "id")
	private Teacher teacher;
	
	@OneToOne(mappedBy= "course")
	private CourseMaterial courseMaterial;
	
	@ManyToMany
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="student_id", referencedColumnName = "id")
	)
	private List<Student> students;
	
	
}
