package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spms.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
					+ " FROM MEMBERS"
					+ " ORDER BY MNO ASC";
			
//			3SQL 실행 객체 준비
			pstmt = conn.prepareStatement(sql);
			
//			4DB에 sql문 보내기
			rs = pstmt.executeQuery();
			
			ArrayList<MemberDto> memberList = new ArrayList<>();
			
			int mno = 0;
			String mname = "";
			String email = "";
			Date creDate = null;
			
//			5.데이터 활용
			while (rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				
				MemberDto memberDto = new MemberDto(mno, mname, email, creDate);
				
				memberList.add(memberDto);
			}
			
			request.setAttribute("memberList", memberList);
			
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/member/MemberListView.jsp");
			
			dispatcher.include(request, response);
			
			
		} catch (Exception e) {
//			throw new ServletException(e);
			System.out.println("회원 목록에서 예외 발생");
			e.printStackTrace();
			
			request.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
			
		}finally {
//		6jdbc 객체 메모리 회수	
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
			
		} // finally
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}
	
}
