package spms.servlets;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spms.dao.MemberDao;


@WebServlet(value = "/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;


		try {
			int mNo = Integer.parseInt(req.getParameter("no"));
			
			//ServletContext 객체 가져옴(없으면 안돼)
			ServletContext sc = this.getServletContext();
			
			//AppInit의 conn 재활용(없으면 안돼)
			conn = (Connection) sc.getAttribute("conn");//DB가져옴
			
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			int result = 0;
			//0이면 등록 실패, 0이외에는 성공
			result = memberDao.delete(mNo);
			
			System.out.println("??????: "+result);
			if(result == 0) {
				
				System.out.println("삭제 실패");
				
			}
			

			res.sendRedirect("./list");//링크불러옴
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		} 

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
	}

}
