package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spms.dto.MemberDto;

@WebServlet("/member/update")
@SuppressWarnings("serial")
public class MemberUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String mNo = "";

		String sql = "";

		RequestDispatcher rd = null;

		// ServletContext sc = this.getServletContext();

//      String driver = sc.getInitParameter("driver");
//      String url = sc.getInitParameter("url");
//      String user = sc.getInitParameter("user");
//      String password = sc.getInitParameter("password");
//      
//      int mNo = Integer.parseInt(req.getParameter("mNo"));
//      

		System.out.println("오라클 드라이버 로드");
		try {
			mNo = req.getParameter("no");
			int no = Integer.parseInt("mNo");

			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE" + " FROM MEMBERS" + " WHERE MNO=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			String mName = "";
			String email = "";
			Date creDate = null;
			
			MemberDto memberDto = new MemberDto();
		if(rs.next()) {
			email = rs.getString("email");
			mName = rs.getString("mname");
			creDate = rs.getDate("CRE_DATE");

			memberDto.setNo(no);
			memberDto.setEmail(email);
			memberDto.setName(mName);
			memberDto.setCreatedDate(creDate);
		}else {
			throw new Exception("해당번호의 회원을 찾을 수 없습니다.");
		}
		
		req.setAttribute("memberDto", memberDto);
		rd = req.getRequestDispatcher("./MemberUpdqteForm.jsp");
		rd.forward(req, res);
			

			// 1. JDBC 드라이버 등록
//         Class.forName(driver);
//         //2.DB등록
//         conn = DriverManager.getConnection(url, user, password);
//         
//         //특정한 사람 정보 조회?
//         sql = "SELECT * FROM MEMBERS"
//                 + " WHERE MNO=?";
//         //3SQL 객체준비
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setInt(1, mNo);
//         //4.DB에 SQL문 보내기
//         rs = pstmt.executeQuery();
//         
//         String mName = "";
//         String email = "";
//         Date creDate = null;
//         
//         while (rs.next()) {
//            mName = rs.getString("MNAME");
//            email = rs.getString("email");
//            creDate = rs.getDate("CRE_DATE");
//         }
//         
//         res.setContentType("text/html");
//         res.setCharacterEncoding("UTF-8");
//         
//         PrintWriter out = res.getWriter();
//         
//         String htmlStr = "";
//         
//         htmlStr += "<!DOCTYPE html><html><head><title>회원정보</title></head>";
//         htmlStr += "<body>";
//         htmlStr += "<h1>회원정보 조회</h1>";
//         htmlStr += "<form action='./update' method='post'>";
//         htmlStr += "번호: <input type='text' name='mNo' value='" + mNo
//               + "' readonly='readonly'><br>";
//         htmlStr += "이름: <input type='text' name='mname' value='" + mName 
//               + "'><br>";
//         htmlStr += "이메일: <input type='text' name='email' value='" + email 
//               + "'><br>";
//         htmlStr += "가입일: " + creDate + "<br>";
//         htmlStr += "<input type='submit' value='수정'>";
//         htmlStr += "<input type='button' value='삭제'"
//        		 + "onclick='location.href=\"./delete?mNo="+mNo+"\"'>";
//         htmlStr += "<input type='button' value='취소' "+"onclick='location.href=\"./list\"'>";
//         htmlStr += "</form>";
//         htmlStr += "</body>";
//         htmlStr += "</html>";
//         
//         out.println(htmlStr);
// 
//         System.out.println("수정 잘 되나?");

		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("error", e);
			rd = req.getRequestDispatcher("/Error.jsp");

			rd.forward(req, res);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회원 정보 수정 post");

		req.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement pstmt = null;

//		ServletContext sc = this.getServletContext();

//		String driver = sc.getInitParameter("driver");
//		String url = sc.getInitParameter("url");
//		String user = sc.getInitParameter("user");
//		String password = sc.getInitParameter("password");

		String email = req.getParameter("email");
		String name = req.getParameter("mname");
		String no = req.getParameter("mNo");
		int mNo = Integer.parseInt(no);

		String sql = "";

		try {
			ServletContext sc=this.getServletContext();
			conn =(Connection)sc.getAttribute("conn");
			sql = "UPDATE MEMBERS" + " SET EMAIL=?, MNAME=?, MOD_DATE=SYSDATE" + " WHERE MNO=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setInt(3, mNo);
			
			pstmt.executeUpdate();

			res.sendRedirect("./list");
//         JDBC 6단계
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//
//			// 회원정보 특정대상 수정
//			sql = "UPDATE MEMBERS" + " SET EMAIL=?, MNAME=?, MOD_DATE=SYSDATE" + " WHERE MNO=?";
//
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, email);
//			pstmt.setString(2, name);
//			pstmt.setString(3, mNo);
//
//			pstmt.executeUpdate();
//
//			res.sendRedirect("./list");

		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");

			rd.forward(req, res);
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
