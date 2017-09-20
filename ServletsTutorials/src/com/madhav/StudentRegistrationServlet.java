package com.madhav;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;
public class StudentRegistrationServlet extends GenericServlet{
	private Connection con;
	public void init(ServletConfig config) {
		ServletContext ctx =config.getServletContext();
		String driver=ctx.getInitParameter("driver");
		String url=ctx.getInitParameter("url");
		String username=ctx.getInitParameter("username");
		String password=ctx.getInitParameter("password");
		try {
		Class.forName(driver);
		con=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("exception in loading driver"+e.getMessage());
		}
		System.out.println("connection created successfully!!!!");
	}
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		PrintWriter out = resp.getWriter();
		int studentId =Integer.parseInt(req.getParameter("studentId"));
		String studentName=req.getParameter("studentName");
		String address=req.getParameter("address");
		try {
		PreparedStatement ps =con.prepareStatement("insert into student values (?,?,?)");
		ps.setInt(1, studentId);
		ps.setString(2, studentName);
		ps.setString(3,address);
		int i=ps.executeUpdate();
		if(i!=0)
			out.println("Student Registration successful!!!");
		else
			out.println("Student Registration failed!!!!");
		}catch(Exception e) {
			out.println("Student Registration failed!!!!");
			e.printStackTrace();
		}
	}
	public void destroy() {
		try {
		con.close();
		}catch(SQLException sqlException) {
			System.out.println("SQLException occured:"+sqlException.getMessage());
		}
	}
}
