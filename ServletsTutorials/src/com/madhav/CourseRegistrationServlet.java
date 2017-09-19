package com.madhav;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CourseRegistrationServlet extends GenericServlet{
	private Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
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
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int courseId =Integer.parseInt(request.getParameter("courseId"));
		String courseName=request.getParameter("courseName");
		int courseFee=Integer.parseInt(request.getParameter("courseFee"));
		try {
		PreparedStatement ps =con.prepareStatement("insert into course values (?,?,?)");
		ps.setInt(1, courseId);
		ps.setString(2, courseName);
		ps.setInt(3,courseFee);
		int i=ps.executeUpdate();
		if(i!=0)
			out.println("Course Registration successful!!!");
		else
			out.println("Course Registration failed!!!!");
		}catch(Exception e) {
			out.println("Course Registration failed!!!!");
			e.printStackTrace();
		}

	}

}
