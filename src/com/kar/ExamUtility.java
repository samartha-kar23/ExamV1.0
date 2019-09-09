package com.kar;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ExamUtility {
	Session session = null;
	SessionFactory factory;
	List<Object[]> category = null;
	
	public ExamUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Object[]> Category(){
		
		
		
		try
		{
			
			factory=new Configuration().configure().buildSessionFactory();
			
			session=factory.openSession();
			Transaction tr=session.beginTransaction();
			Query query=session.createQuery("select e.examname,e.id from Exams e");
			category = (List<Object[]>)query.list();
			//list=query.list();
//			Iterator iter = list.iterator();
//	
//		while(iter.hasNext())
//			{
//			System.out.println(iter.next());
//				}
		tr.commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	
		
		return category;

		
	}

}
