package com.madhav;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
public class LoadOnStartUpExample implements Servlet{
	
	public void init(ServletConfig conf) {
		System.out.println("init method");
	}
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		System.out.println("service method");
	}
	public void destroy() {
		System.out.println("destroy method");
	}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null;
	}

}
