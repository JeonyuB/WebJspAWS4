package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
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
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		String mNo = "";

		try {
			mNo = req.getParameter("no");
			int no = Integer.parseInt(mNo);
			
			//this는 ServletContext
			ServletContext sc = this.getServletContext();
			//또 new해서 객체 생성하지 않게 (appinitservlet에서 만든)conn재활용.
			conn = (Connection) sc.getAttribute("conn");

			//멤버객체 생성
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);//윗줄에서 만든 conn을 여러곳(memberDao)에서 재사용하게 연결
		
			//memberDto객체에 memberDao.selectOne(no)값을 넣음(반환값이 MemberDto이기 때문에 MemberDto타입)
			MemberDto memberDto = memberDao.selectOne(no);
			
			//MemberUpdateForm.jsp에서 <jsp:useBean id="memberDto"...의 id를 가져올거라 "memberDto", 
			//memberDto가 위에 선언한 memberDto이다.
			req.setAttribute("memberDto", memberDto);
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./MemberUpdateForm.jsp");
			dispatcher.forward(req, res);

		}catch (Exception e) {

			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	
		Connection conn = null;
		PreparedStatement pstmt = null;

		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String no = req.getParameter("mNo");
		int mNo = Integer.parseInt(no);



		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = new MemberDto();
			
			memberDto.setEmail(email);
			memberDto.setName(name);
			memberDto.setNo(mNo);
			
			memberDto = memberDao.update(memberDto);
			
			res.sendRedirect("./list");
			
		} catch (Exception e) {

			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}finally {			
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally
		
	}
	
}
