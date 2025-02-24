package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
@SuppressWarnings("serial")
public class MemberAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("doGet을 탄다");

		res.setContentType("text/html");
		res.sendRedirect("../member/MemberForm.jsp");

		PrintWriter out = res.getWriter();

		String htmlStr = "";

		htmlStr += "<!DOCTYPE html><html><head><meta charset=\"UTF-8\">" + "	<title>회원등록</title></head>"
				+ "<body><h1>회원등록</h1>" + "	<form action='add' method='post'>"
				+ "		이름: <input type='text' name='mname'><br>" + "		이메일: <input type='text' name='email'><br>"
				+ "		암호: <input type='password' name='password'><br>" + "		<input type='submit' value='추가'>"
				+ "		<input type='reset' value='취소'>" + "	</form></body></html>";

		out.println(htmlStr);

	}

	// 추가버튼 누르면 do Post 실행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 수행함");

		Connection conn = null;
		PreparedStatement pstmt = null;

		ServletContext sc = getServletContext();

		String emailStr = req.getParameter("email");
		String pwdStr = req.getParameter("password");
		String nameStr = req.getParameter("mname");

		try {
//      ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			String sql = "INSERT INTO MEMBERS" + "(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)"
					+ "VALUES(MEMBERS_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emailStr);
			pstmt.setString(2, pwdStr);
			pstmt.setString(3, nameStr);

			pstmt.executeUpdate();

			// 추가
			res.sendRedirect("./list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		} // finally 종료

	}
}
