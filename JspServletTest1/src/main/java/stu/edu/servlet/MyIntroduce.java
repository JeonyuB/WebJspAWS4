package stu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyIntroduce implements Servlet{

	
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
		
		this.config=config;
		String nameStr = this.config.getInitParameter("nameStr");
		String ageStr = this.config.getInitParameter("age");
		
		int ageNum = Integer.parseInt(ageStr);
		
		System.out.println("내 이름: " + nameStr);
		System.out.println("내 나이: " + ageNum);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		
		String htmlStr = "";
		
		htmlStr += "<!DOCTYPE html>";
		htmlStr += "<html>";
		htmlStr += "<head>";
		htmlStr += "<meta charset=\"UTF-8\">";
		htmlStr += "<title> jsp&servlet 학습 </title>";
		htmlStr += "</head>";
		htmlStr += "<body>";
		for(int i = 1 ; i<=6; i++) {
			htmlStr += "<h"+i+">"+"jsp&servlet 학습"+i+"</h"+i+">";
		}
		
		htmlStr += "</body>";
		htmlStr += "</html>";
		printWriter.append(htmlStr);
	}
	


}
