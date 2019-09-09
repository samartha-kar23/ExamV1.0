package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stud
	        try {
	            RegisterDetails user = new RegisterDetails();
	            user.addExaminerDetails("john", "sam", "john123", "johnsam@gmail.com", "9123423312","SeedInfotech");
	            user.addStudentDetails("Ram","kumar","ram123", "ram@gmail.com", "9457918071","NIT Meghalaya");
	            request.getRequestDispatcher("upload.jsp").forward(request, response);
	            PrintWriter pw = response.getWriter();
	            pw.println("success");
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }
	}

}
