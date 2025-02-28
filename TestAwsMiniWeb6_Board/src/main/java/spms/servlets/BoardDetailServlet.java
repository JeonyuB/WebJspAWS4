package spms.servlets;

import java.io.IOException;
import java.sql.Connection;

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
@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("보드디테일 doget 실행");
		Connection conn = null;
		String bNo = "";

		try {

			bNo = req.getParameter("no");
			int bno = Integer.parseInt(bNo);
			
			//this는 ServletContext
			ServletContext sc = this.getServletContext();
			
			//또 new해서 객체 생성하지 않게 (appinitservlet에서 만든)conn재활용.
			conn = (Connection) sc.getAttribute("conn");

			//멤버객체 생성
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);//윗줄에서 만든 conn을 여러곳(boardDao)에서 재사용하게 연결
		
			//boardDto객체에 boardDao.selectOne(no)값을 넣음(반환값이 BoardDto이기 때문에 BoardDto타입)
			BoardDto boardDto = boardDao.boardDetail(bno);
			
			//BoardUpdateForm.jsp에서 <jsp:useBean id="boardDto"...의 id를 가져올거라 "boardDto", 
			//boardDto가 위에 선언한 boardDto이다.
			req.setAttribute("boardDto", boardDto);
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./Board.jsp");
			dispatcher.forward(req, resp);

		}catch (Exception e) {

			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
