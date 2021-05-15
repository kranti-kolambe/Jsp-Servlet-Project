package com.khk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khk.config.DbConnection;

/**
 * Servlet implementation class ListOfUserServlet
 */
@WebServlet("/listOfUser")
public class ListOfUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retrieve list of user
		try {
		Connection con=DbConnection.getConnection();
		String sql="select * from user";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<User> l=new ArrayList<User>();
		while(rs.next())
		{
			int uid=rs.getInt("id");
			String userName=rs.getString("username");
			String email=rs.getString("emailID");
			String psw=rs.getString("password");
			String city=rs.getString("city");
			String status=rs.getString("status");
			User u=new User(uid, userName, email, psw, city, status);
			l.add(u);
		}
		//dispatch result to jsp
		request.setAttribute("userslist", l);
		RequestDispatcher rd=request.getRequestDispatcher("listOfUser.jsp");
		rd.forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
