package stu.edu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl4")
@SuppressWarnings("serial")
public class MyTest2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int[] numArr = new int[4];
		
		for(int i = 0; i< numArr.length; i++) {
			numArr[i] = i;
		}
		
		List<String> strList = new ArrayList<String>();
		
		for(int i = 0; i< 4; i++) {
			strList.add("자바 어려움"+i);
		}
		

		request.setAttribute("numArr", numArr);
		request.setAttribute("strList", strList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jstl4.jsp");
		rd.forward(request, response);
	}
}
