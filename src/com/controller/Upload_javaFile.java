package com.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.utilities.Questions;

public class Upload_javaFile {
	
	public void upload(String question, String option_1, String option_2, String option_3, String option_4,
			String option_crt) {
		 try {
	            // 1. configuring hibernate
	            Configuration configuration = new Configuration().configure();
	 
	            // 2. create sessionfactory
	            SessionFactory sessionFactory = configuration.buildSessionFactory();
	 
	            // 3. Get Session object
	            Session session = sessionFactory.openSession();
	 
	            // 4. Starting Transaction
	            Transaction transaction = session.beginTransaction();
	            Questions questions = new Questions();
	            questions.setQuestion(question);
	            questions.setOption_1(option_1);
	            questions.setOption_2(option_2);
	            questions.setOption_3(option_3);
	            questions.setOption_4(option_4);
	            questions.setOption_crt(option_crt);
	            
	            
	            
	            
		
		
	}catch (HibernateException e) {
        System.out.println(e.getMessage());
        System.out.println("error");
    }

}
}
