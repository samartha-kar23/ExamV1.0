package com.utilities;

import java.util.List;

public class Exams {
	int id;
	List <Student>students;
	String examname;
	List<Questions> questions;
	List<Results> results;
	
	
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Exams() {
		super();
	}
	public Exams(int id, String examname, Examiner examiner) {
		super();
		this.id = id;
		this.examname = examname;
		//this.examiner=examiner;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	
}