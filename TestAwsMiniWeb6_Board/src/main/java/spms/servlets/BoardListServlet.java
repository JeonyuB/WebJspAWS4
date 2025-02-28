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
import spms.dao.BoardDao;
import spms.dto.BoardDto;

@SuppressWarnings("serial")
@WebServlet("/board/BoardList")
public class BoardListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("게시판리스트 doget");
		Connection conn = null;
		
		try {

			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");

			BoardDao boardDao = new BoardDao();
			//주입
			boardDao.setConnection(conn);
			
			
			ArrayList<BoardDto> boardList = null;
			//boardDao는 DB에 관한 로직만 존재해야함
			//회원목록 가져옴
			boardList = (ArrayList<BoardDto>)boardDao.boardList();
			
			//회원목록 정보 준비
			req.setAttribute("boardList", boardList);
			
			//페이지 준비
			RequestDispatcher dispatcher = 
				req.getRequestDispatcher("./BoardList.jsp");
			//dispatcher를 통해 링크 화면으로 이어짐.
			dispatcher.include(req, resp);
			
			
			
		} catch (Exception e) {
//			throw new ServletException(e);
			System.out.println("게시판 목록에서 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("error", e);
			
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
