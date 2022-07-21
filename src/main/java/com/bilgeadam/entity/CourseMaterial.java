package com.bilgeadam.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class CourseMaterial {
	
	@Id
	@GeneratedValue
	private long id;
	private String url;
	
	
	@OneToOne(optional=false)
	@JoinColumn(name="course_id" , referencedColumnName = "id")
	private Course course;
	
}
