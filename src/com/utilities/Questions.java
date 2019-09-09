package com.utilities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Questions {

	
	int id;
	String Question,option_1,option_2,option_3,option_4,option_crt;
	Exams exam;
	
	public Exams getExam() {
		return exam;
	}

	public void setExam(Exams exam) {
		this.exam = exam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questions() {
		super();
		
	}

	public String getQuestion() {
		return Question;
	}
	
	public Questions(String question, String option_1, String option_2, String option_3, String option_4,
			String option_crt) {
		super();
		Question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.option_crt = option_crt;
	}
	
	public void setQuestion(String question) {
		Question = question;
	}
	
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public String getOption_crt() {
		return option_crt;
	}
	public void setOption_crt(String option_crt) {
		this.option_crt = option_crt;
	}
	public void addquestions(String question, String option_1, String option_2, String option_3, String option_4,
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
            this.setQuestion(question);
            this.setOption_1(option_1);
            this.setOption_2(option_2);
            this.setOption_3(option_3);
            this.setOption_4(option_4);
            this.setOption_crt(option_crt);
            session.save(this);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
	
	
}
