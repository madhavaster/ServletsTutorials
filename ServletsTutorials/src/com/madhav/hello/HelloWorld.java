package com.madhav.hello;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.PrintWriter;
import java.io.IOException;
public class HelloWorld implements Servlet{

	public void init(ServletConfig sc) {};
	public void service(ServletRequest req,ServletResponse resp) {
		String name =req.getParameter("p1");
		resp.setContentType("text/html");
		PrintWriter out=null;
		try {
			out =resp.getWriter();
		}catch(IOException ioe) {
			System.out.println("IOException madhav"+ioe.getMessage());
		}
		out.println("name is"+name);
	}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null;
	}
	public void destroy() {
		
	}
}
