package com.hibernateapp.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="college")
@Table(name="college_details")
public class CollegeDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="college_id")
	private int collegeId;
	
	@Column(name="college_name")
	private String collegeName;
	
	@ElementCollection
	private Collection<String> courses;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="college_students", 
	   joinColumns=@JoinColumn(name="college_id"), 
	   inverseJoinColumns=@JoinColumn(name="student_id")
	)
	private Collection<StudentDTO> students;
	
	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Collection<String> getCourses() {
		return courses;
	}

	public void setCourses(Collection<String> courses) {
		this.courses = courses;
	}

	public Collection<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Collection<StudentDTO> students) {
		this.students = students;
	}
}
