package com.khk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khk.config.DbConnection;
//import org.omg.CORBA.portable.ApplicationException;
//import com.khk.beans.UserBeans;
//import com.javawebapp.model.UserModel;
import com.khk.utility.EmailMessage;
import com.khk.utility.EmailUtility;
//import com.khk.utility.ServletUtility;

@WebServlet("/forgetPsw")
public class ForgetPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement ps;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    String emailID = request.getParameter("emailID").trim();
	    String username=request.getParameter("username");
	    EmailMessage emailbean = new EmailMessage();
	   // UserBeans user = UserModel.FindUserPassword(email);
	    try {
			if(con==null)
			{
				con=DbConnection.getConnection();
			}
		String sql="select password from user where username=? and emailID=?";
		
		 ps=con.prepareStatement(sql);
		 ps.setString(1, username);
		 ps.setString(2,emailID);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
			 emailbean.setTo(emailID);
			 emailbean.setMessage("Hii "+emailID+ "Your Password is: "+rs.getString("password"));
			 EmailUtility.sendMail(emailbean);
		     request.setAttribute("sendMail", "Mail has been sent successfully..");
		     System.out.println("Mail has been sent successfully..to "+emailID);
		     RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		 }
		 else	          
		 {      
	           	request.setAttribute("sendMail", "Something went wrong..");
	           	System.out.println("Something went wrong..");
	           	RequestDispatcher rd=request.getRequestDispatcher("forgetPsw.jsp");
				rd.forward(request, response);
		 }
		 
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    //ServletUtility.forward("/jsp/forgetpassword.jsp",request, response);
	  }
}
