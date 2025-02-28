package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		
		try {

			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");

			MemberDao memberDao = new MemberDao();
			//주입
			memberDao.setConnection(conn);
			
			
			ArrayList<MemberDto> memberList = null;
			//memberDao는 DB에 관한 로직만 존재해야함
			//회원목록 가져옴
			memberList = (ArrayList<MemberDto>)memberDao.selectList();
			
			//회원목록 정보 준비
			request.setAttribute("memberList", memberList);
			
			//페이지 준비
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("./MemberListView.jsp");
			//dispatcher를 통해 링크 화면으로 이어짐.
			dispatcher.include(request, response);
			
			
		} catch (Exception e) {
//			throw new ServletException(e);
			System.out.println("회원 목록에서 예외 발생");
			e.printStackTrace();
			
			request.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
			
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}
	
}
