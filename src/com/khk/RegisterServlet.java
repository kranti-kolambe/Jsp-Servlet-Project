package com.khk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khk.config.DbConnection;


@WebServlet("/registerUser")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		/*
		 * String username=request.getParameter("username"); String
		 * psw=request.getParameter("psw"); String city=request.getParameter("city");
		 */
			if(con==null)
			{
			con=DbConnection.getConnection();
			}
			PreparedStatement ps=con.prepareStatement("insert into user(username, password, city) values(?,?,?)");
			ps.setString(1,request.getParameter("username"));
			ps.setString(2,request.getParameter("psw"));
			ps.setString(3,request.getParameter("city"));
			int r=ps.executeUpdate();
			if(r>0) {
				request.setAttribute("msg","User Successfully added!!");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg","Something went wrong!!");
				RequestDispatcher rd=request.getRequestDispatcher("addUser.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
