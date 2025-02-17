package stu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BasicInfo implements Servlet{
	ServletConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 최초실행");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service 최초실행");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		
		String htmlStr = "";
		
		htmlStr += "<!DOCTYPE html>";
		htmlStr += "<html>";
		htmlStr += "<head>";
		htmlStr += "<meta charset=\"UTF-8\">";
		htmlStr += "<title> 내이름 찾았다 </title>";
		htmlStr += "</head>";
		htmlStr += "<body>";
		htmlStr += "<h1>"+"이런 느낌"+"</>";
		
		for(int i = 0; i<3; i++) {
			htmlStr +="<div style='border:1px solid black;'>"
					+"홍길동"+"</div>";
		}
		htmlStr += "12324";
		htmlStr += "</body>";

		htmlStr += "</html>";
		printWriter.append(htmlStr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
