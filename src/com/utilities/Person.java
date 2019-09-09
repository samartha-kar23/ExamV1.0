package com.utilities;

public class Person {
	int id;
	boolean approval=false;
	String fname,lname,uemail,upass;
	String umobile;
	
	
	public Person() {
		super();
	}
	public Person(int id,String fname, String lname, String uemail, String upass, String umobile) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.uemail = uemail;
		this.upass = upass;
		this.umobile = umobile;
	}
	
	
	public boolean isApproval() {
		return approval;
	}
	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUmobile() {
		return umobile;
	}
	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}
	
}
