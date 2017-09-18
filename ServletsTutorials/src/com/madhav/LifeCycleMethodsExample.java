package com.madhav;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class LifeCycleMethodsExample implements Servlet{
	
	public LifeCycleMethodsExample() {
		System.out.println("no arg constructor");
	}
	public void init(ServletConfig config) {
		System.out.println("init method");
	}
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		System.out.println("service method");
	}
	public void destroy() {
		System.out.println("destroy method");
	}
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig method");
		return null;
	}
	public String getServletInfo() {
		System.out.println("getServletInfo method");
		return null;
	}
}
