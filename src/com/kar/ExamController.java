package com.kar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int presentQuestion_index = 0;
	QuestionsUtility Q;
    public ExamController() {
        super();
  
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		Q = new QuestionsUtility();
	}

	public void nextQ(){
    	presentQuestion_index++;
    	
    }
    public void prevQ(){
    	presentQuestion_index--;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("Solve.jsp");
		
		Q.Category(request.getParameter("Start"));
		request.setAttribute("currentQuestion", presentQuestion_index);
		request.setAttribute("question",Q.question(presentQuestion_index));
		request.setAttribute("totalQuestions",Q.NumberOfQuestions());
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println(">" + request.getParameter("N"));
		System.out.println("<" + request.getParameter("P"));
		RequestDispatcher rd = request.getRequestDispatcher("Solve.jsp");
		//System.out.println(request.getParameter("P"));
		if(request.getParameter("refresh") != null)
		{
		
		//Next Question toggle
		if(request.getParameter("next")!=null) {
			//request.setAttribute("next", null);
			presentQuestion_index = Integer.parseInt(request.getParameter("N"));
			if(presentQuestion_index < Q.NumberOfQuestions()) {
				//nextQ();
				request.setAttribute("question",Q.question(presentQuestion_index));
				request.setAttribute("currentQuestion", presentQuestion_index);
				request.setAttribute("cOption",Q.getResponse(presentQuestion_index));
				request.setAttribute("totalQuestions",Q.NumberOfQuestions());
				rd.forward(request, response);
				//doGet(request, response);
				//response.sendRedirect("Redirect?ADD=success");
				
			}
			else {
				request.setAttribute("question",Q.question(Q.NumberOfQuestions()-1));
				request.setAttribute("currentQuestion", Q.NumberOfQuestions()-1);
				request.setAttribute("cOption",Q.getResponse(presentQuestion_index));
				request.setAttribute("totalQuestions",Q.NumberOfQuestions());
				rd.forward(request, response);
				//doGet(request, response);
			}
		}
		//Previous question toggle
		if(request.getParameter("prev")!=null) {
			//request.setAttribute("next", null);
			presentQuestion_index = Integer.parseInt(request.getParameter("P"));
			if(presentQuestion_index >= 0) {
				//prevQ();
				request.setAttribute("question",Q.question(presentQuestion_index));
				request.setAttribute("currentQuestion", presentQuestion_index);
				request.setAttribute("cOption",Q.getResponse(presentQuestion_index));
				request.setAttribute("totalQuestions",Q.NumberOfQuestions());
				rd.forward(request, response);
				//doGet(request, response);
			}	
			else {
				request.setAttribute("question",Q.question(0));
				request.setAttribute("currentQuestion", 0);
				request.setAttribute("cOption",Q.getResponse(presentQuestion_index));
				request.setAttribute("totalQuestions",Q.NumberOfQuestions());
				rd.forward(request, response);
				//doGet(request, response);
			}
		}
		//Save Question toggle
		if (request.getParameter("save")!=null) {
			presentQuestion_index = Integer.parseInt(request.getParameter("SV"));
			System.out.println(presentQuestion_index);
			System.out.println(request.getParameter("op"));
			request.setAttribute("currentQuestion", presentQuestion_index);
			request.setAttribute("question",Q.question(presentQuestion_index));
			request.setAttribute("chosenOption",Q.saveResponse(request.getParameter("op"),presentQuestion_index));
			request.setAttribute("cOption",Q.getResponse(presentQuestion_index));
			request.setAttribute("totalQuestions",Q.NumberOfQuestions());
			rd.forward(request, response);
		}
		
		if(request.getParameter("sub")!=null) {
			request.setAttribute("score",Q.submitResponse());
			RequestDispatcher rd2 = request.getRequestDispatcher("result.jsp");
			rd2.forward(request, response);
		}
		
		}

		else {
			rd.forward(request, response);
		}


		
	}

}
