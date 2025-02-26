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

@WebServlet(value = "/auth/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		String name = "";
		
		String sql = "";
		int colIndex = 1;
		
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");
			
			sql += "SELECT EMAIL, MNAME";
			sql += " FROM MEMBERS";
			sql += " WHERE EMAIL = ? AND PWD = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				email = rs.getString("email");
				name = rs.getString("mname");
				
				MemberDto memberDto = new MemberDto();
				
				memberDto.setEmail(email);
				memberDto.setName(name);
				
				HttpSession session = req.getSession();
				session.setAttribute("memberDto", memberDto);
				
				res.sendRedirect("../member/list");
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("./LoginFail.jsp");
				
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
//					System.out.println("ResultSet 종료");
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
//					System.out.println("PreparedStatement(쿼리) 종료");
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} // finally 종료
	}
	
}
