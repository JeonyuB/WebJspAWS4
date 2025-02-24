package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spms.dto.MemberDto;

@WebServlet(value="/auth/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		session.invalidate();//객체에 상관없이 전부 지우는 메서드
		//session.removeAttribute(("memberDto"); 
		//위는 session에 키를 지정("memberDto"키를 memberDto값으로 지정)하는 session.setAttribute("memberDto", memberDto);와는 달리 session에서 지정한 memberDto키만을 지운다.
		res.sendRedirect("./login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		
		
	}

}
