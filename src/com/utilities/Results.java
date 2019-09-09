package com.utilities;

public class Results {
	int id;
	Exams exam;
	Student student;
	int marks;
	String status;
	
	public Results() {
		super();
	}
	public Results(int id, Exams exam, Student student, int marks, String status) {
		super();
		this.id = id;
		this.exam = exam;
		this.student = student;
		this.marks = marks;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exams getExam() {
		return exam;
	}
	public void setExam(Exams exam) {
		this.exam = exam;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
