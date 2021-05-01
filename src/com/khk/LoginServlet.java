package com.khk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.khk.config.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   Connection con; 
	   PreparedStatement ps;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String psw=request.getParameter("psw");
		System.out.println("Hi");
		try {
			if(con==null)
			{
				con=DbConnection.getConnection();
			}
		String sql="select username,password from user where username=? and password=?";
		
		 ps=con.prepareStatement(sql);
		 ps.setString(1, username);
		 ps.setString(2,psw);
		 ResultSet rs=ps.executeQuery();
		 
		 if(rs.next())
		 {
			 		HttpSession session=request.getSession(true);
			 		session.setAttribute("username", username);
					RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

	