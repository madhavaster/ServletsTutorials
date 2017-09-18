package com.madhav;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
public class GenericServletExample extends GenericServlet{
	
	public GenericServletExample() {
		System.out.println("no arg constructor of GenericServletExample");
	}
	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException{
		System.out.println("servie method of GenericServletExample");
	}
}
