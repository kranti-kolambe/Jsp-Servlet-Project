package com.khk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfUserServlet
 */
@WebServlet("/listOfUser")
public class ListOfUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retrieve list of user
		
		//dispatch result to jsp
		RequestDispatcher rd=request.getRequestDispatcher("listOfUser.jsp");
		rd.forward(request, response);
		
	}

}
