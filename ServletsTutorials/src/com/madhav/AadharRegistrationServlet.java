package com.madhav;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class AadharRegistrationServlet extends HttpServlet{
	private Connection conn;
	public void init(ServletConfig config) {
		System.out.println("madhava");
		ServletContext context =config.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String username=context.getInitParameter("username");
		String password=context.getInitParameter("password");
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Class not found:"+cnfe.getMessage());
		}catch(SQLException se) {
			System.out.println("sqlexception:"+se.getMessage());
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session =request.getSession();
		PreparedStatement ps;
		int formNumber = Integer.parseInt(request.getParameter("formNumber"));
		String field1,field2,field3,field4,field5,field6,field7,field8,field9;
		field1=field2=field3=field4=field5=field6=field7=field8=field9="";
		int i=0;
		if(formNumber==1) {
			field1 =request.getParameter("field1");
			field2 =request.getParameter("field2");
			field3 =request.getParameter("field3");
			session.setAttribute("field1", field1);
			session.setAttribute("field2", field2);
			session.setAttribute("field3", field3);
			response.sendRedirect("./AadharRegistrationForm2.html");
		}else if(formNumber==2) {
			field4=request.getParameter("field4");
			field5=request.getParameter("field5");
			field6=request.getParameter("field6");
			session.setAttribute("field4", field4);
			session.setAttribute("field5", field5);
			session.setAttribute("field6", field6);
			response.sendRedirect("./AadharRegistrationForm3.html");
		}else if(formNumber==3) {
			field7=request.getParameter("field7");
			field8=request.getParameter("field8");
			field9=request.getParameter("field9");
			field1=(String)session.getAttribute("field1");
			field2=(String)session.getAttribute("field2");
			field3=(String)session.getAttribute("field3");
			field4=(String)session.getAttribute("field4");
			field5=(String)session.getAttribute("field5");
			field6=(String)session.getAttribute("field6");
			try {
				ps =conn.prepareStatement("insert into crmuser.aadharregistration values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, field1);
				ps.setString(2, field2);
				ps.setString(3, field3);
				ps.setString(4, field4);
				ps.setString(5, field5);
				ps.setString(6, field6);
				ps.setString(7, field7);
				ps.setString(8, field8);
				ps.setString(9, field9);
				i=ps.executeUpdate();
				System.out.println("i value is"+i);
			}catch(SQLException se) {
				System.out.println("sqlException:"+se.getMessage());
			}
			if(i!=0) {
				System.out.println("Aadhar Registration Successful");
			}else {
				System.out.println("Aadhar Registration failed");
			}
		}
	}
}
