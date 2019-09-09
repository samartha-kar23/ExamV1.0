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

import com.utilities.Examiner;
import com.utilities.Exams;
import com.utilities.Student;

/**
 * Servlet implementation class AddExams
 */
@WebServlet("/AddExams")
public class AddExams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // 1. configuring hibernate
        Configuration configuration = new Configuration().configure();

        // 2. create sessionfactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 3. Get Session object
        Session session = sessionFactory.openSession();

        // 4. Starting Transaction
        Transaction transaction = session.beginTransaction();
		//String name=(String) request.getAttribute("uname");
		Student examiner=(Student) session.load(Student.class,new Integer(1291));
		System.out.println(examiner.getFname());
		List<Exams> list;
		Exams exam=new Exams();
		exam.setId(1433);
		exam.setExamname("Bhosda");   

		list=examiner.getExams();
		list.add(exam);
		examiner.setExams(list);
		session.save(examiner);
		transaction.commit();
		session.close();
		
		
		
	}

}
