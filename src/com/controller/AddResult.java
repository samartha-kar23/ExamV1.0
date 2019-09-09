package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.utilities.Exams;
import com.utilities.Results;
import com.utilities.Student;

/**
 * Servlet implementation class AddResult
 */
@WebServlet("/AddResult")
public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResult() {
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
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration().configure();
		 
        // 2. create sessionfactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 3. Get Session object
        Session session = sessionFactory.openSession();

        // 4. Starting Transaction
        Transaction transaction = session.beginTransaction();
        Student student =(Student) session.load(Student.class,1298);
		System.out.println(student.getFname());
		transaction.commit();
		session.close();
		
		
		
	}

}
