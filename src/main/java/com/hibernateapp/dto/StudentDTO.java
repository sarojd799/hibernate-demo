package com.hibernateapp.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vo.AddressVO;
import vo.SkillsVO;

@Entity(name="student")
@Table(name="student_details")
@NamedQuery(name="student.byId" , query="from student where studentId = :studentId")
public class StudentDTO {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="email")
	private String email;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="student_address")
	@Embedded
	private AddressVO address;
	
	@Column(name="skills")
	@Embedded
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="student_skills")
	private Collection<SkillsVO> skills = new ArrayList<SkillsVO>();
	
	/*===========================================================================*/
			
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + ", gender="
				+ gender + ", dob=" + dob + ", address=" + address + ", skills=" + skills + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public Collection<SkillsVO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillsVO> skills) {
		this.skills = skills;
	}
	
}
