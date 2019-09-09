package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.oreilly.servlet.MultipartRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.utilities.Examiner;
import com.utilities.Exams;
import com.utilities.Questions;
import com.utilities.Student;



/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path="C:\\eclipse-jee-oxygen-1-win32-x86_64\\eclipse\\FinalDashboard\\WebContent";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Configuration configuration = new Configuration().configure();
		 int id=0;
		 
         // 2. create sessionfactory
         SessionFactory sessionFactory = configuration.buildSessionFactory();

         // 3. Get Session object
         Session session = sessionFactory.openSession();

         // 4. Starting Transaction
         Transaction transaction = session.beginTransaction();
		MultipartRequest m=new MultipartRequest(request,path); 
		  //FileInputStream input_document = new FileInputStream(new File(path+"\\Book1.xlsx")); //Read XLS document - Office 97 -2003 format     
          XSSFWorkbook my_xls_workbook = new XSSFWorkbook(path+"\\Book1.xlsx"); //Read the Excel Workbook in a instance object    
          XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); //This will read the sheet for us into another object
          Iterator<Row> rowIterator = my_worksheet.rowIterator(); // Create iterator object
          Exams exam=(Exams) session.load(Exams.class,new Integer(1001));
          while(rowIterator.hasNext()) {
        	  		id++;
        	  		Questions question=new Questions();
        	  		question.setId(id);
        	  		question.setExam(exam);
                  Row row = rowIterator.next(); //Read Rows from Excel document 
                  Iterator<Cell> cellIterator = row.cellIterator();//Read every column for every row that is READ
                  Cell cell = cellIterator.next(); 
                  question.setQuestion(cell.getStringCellValue());
                  cell = cellIterator.next(); 
                  question.setOption_1(cell.getStringCellValue());
                  cell = cellIterator.next(); 
                  question.setOption_2(cell.getStringCellValue());
                  cell = cellIterator.next();
                  question.setOption_3(cell.getStringCellValue());
                  cell = cellIterator.next();
                  question.setOption_4(cell.getStringCellValue());
                  cell = cellIterator.next();
                  question.setOption_crt(cell.getStringCellValue());
                  session.save(question);
                  transaction.commit();
          System.out.println(""); // To iterate over to the next row
          }
          

	}

}
