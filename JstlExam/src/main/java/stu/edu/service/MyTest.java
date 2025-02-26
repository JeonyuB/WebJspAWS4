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

@WebServlet("/myTest")
@SuppressWarnings("serial")
public class MyTest extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		List<String> teamList = new ArrayList<String>();
//		
//		
//		teamList.add("오우람");
//		teamList.add("박찬정");
//		teamList.add("박진우");
//		teamList.add("전유빈");
		

//		request.setAttribute("teamList", teamList);
		
//		List<String> nameList = new ArrayList<String>();
//1안		
//		Map<String, String> nameMap = new HashMap<String,String>();
//		
//		nameMap.put("oul", "팀장");
//		nameMap.put("pcj", "팀원");
//		nameMap.put("pju", "팀원");
//		nameMap.put("jyb", "본인(팀원)");
		
//		request.setAttribute("nameMap", nameMap);
//2안		
//		nameList.add("팀장");
//		nameList.add("팀원");
//		nameList.add("팀원");
//		nameList.add("팀원");
		
//		request.setAttribute("nameList", nameList);
		
//3안 
		Map<String, String> nameMap = new HashMap<String,String>();
		
		nameMap.put("오우람", "팀장");
		nameMap.put("박찬정", "팀원");
		nameMap.put("박진우", "팀원");
		nameMap.put("전유빈", "본인(팀원)");
		
		
//		List<String> teamList = new ArrayList<String>(nameMap.keySet());
		List<String> teamList = new ArrayList<String>();
		
		
		System.out.println(teamList);
		
		request.setAttribute("nameMap", nameMap);
		request.setAttribute("teamList", teamList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jstl.jsp");
		rd.forward(request, response);
	}
}
