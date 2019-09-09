package com.utilities;

import java.util.List;

public class Student extends Person {
	List <Exams>exams;
	String university;
	List<Results> results;


	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public boolean isApproval() {
		// TODO Auto-generated method stub
		return this.approval;
	}

	@Override
	public void setApproval(boolean approval) {
		this.approval=approval;
	}
	

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id,String fname, String lname, String uemail, String upass, String umobile,String university,List<Exams> exams) {
		super(id,fname, lname, uemail, upass, umobile);
		this.university=university;
		this.exams = exams;
		// TODO Auto-generated constructor stub
	}


	public List<Exams> getExams() {
		return exams;
	}

	public void setExams(List<Exams> exams) {
		this.exams = exams;
	}

	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	

}