package com.utilities;

import java.util.List;

public class Examiner extends Person{

	String organisation;
	 List <Exams> exams;
	
	@Override
	public String toString() {
		return "Examiner [organisation=" + organisation + ", exams=" ;
	}

	public List<Exams> getExams() {
		return exams;
	}
	public void setExams(List<Exams> exams) {
		this.exams = exams;
	}

	@Override
	public boolean isApproval() {
		// TODO Auto-generated method stub
		return this.approval;
	}

	@Override
	public void setApproval(boolean approval) {
		// TODO Auto-generated method stub
		this.approval=approval;
	}

	public Examiner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Examiner(int id,String fname, String lname, String uemail, String upass, String umobile,String organisation,List <Exams>exams) {
		super(id,fname, lname, uemail, upass, umobile);
		this.organisation = organisation;
		
		// TODO Auto-generated constructor stub
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	
	
	
	
}
