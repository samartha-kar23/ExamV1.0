package com.utilities;

public class Admin extends Person{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String fname, String lname, String uemail, String upass, String umobile) {
		super(id, fname, lname, uemail, upass, umobile);
		// TODO Auto-generated constructor stub
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
	
		
	
	
}
