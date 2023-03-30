package com.abc.learning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "stream")
	private String stream;

	@OneToOne(mappedBy = "studentDetails", cascade = CascadeType.ALL) // BiDirectional mapping
	private Student student;

	public StudentDetails() {
	}

	public StudentDetails(String collegeName) {
		this.collegeName = collegeName;
	}

	public StudentDetails(String collegeName, String stream) {
		this.collegeName = collegeName;
		this.stream = stream;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", collegeName=" + collegeName + ", stream=" + stream + "]";
	}

}
