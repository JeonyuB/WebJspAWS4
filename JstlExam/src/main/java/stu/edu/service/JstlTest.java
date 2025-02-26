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

@WebServlet("/jstlTest")
@SuppressWarnings("serial")
public class JstlTest extends HttpServlet{
	
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
		
		Map<String, String> nameMap = new HashMap<String,String>();
		
		nameMap.put("pcj", "정파");
		nameMap.put("jhs", "사파");
		nameMap.put("our", "마교");
		nameMap.put("jyb", "백성");
		
		request.setAttribute("nameMap", nameMap);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jstlTest.jsp");
		rd.forward(request, response);
	}
}
