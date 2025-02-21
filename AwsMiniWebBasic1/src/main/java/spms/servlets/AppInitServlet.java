package spms.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

//어플리케이션을 초기화하는 기능
@SuppressWarnings("serial")
public class AppInitServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 준비...");
		super.init(config);

		ServletContext sc = this.getServletContext();

		Connection conn = null;

		String driver = "";
		String url = "";
		String user = "";
		String password = "";

		try {
//DB연결을 분리(매번 연결 안해도 되게끔)
			driver = sc.getInitParameter("driver");
			url = sc.getInitParameter("url");
			user = sc.getInitParameter("user");
			password = sc.getInitParameter("password");

//	         1JDBC 드라이버 등록
			Class.forName(driver);
//	         2DB연결
			conn = DriverManager.getConnection(url, user, password);

			sc.setAttribute("conn", conn);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC API 오류 발생");
			e.printStackTrace();

		} catch (SQLException e) {
			// throw new ServletException(e);
			System.out.println(" DB 연결오류 발생");
			e.printStackTrace();

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 마무리!");
		super.destroy();

		ServletContext sc = this.getServletContext();

		try {
			//conn이라는 key의 value를 가져옴
			Connection conn = (Connection) sc.getAttribute("conn");

			if (conn != null) {
				//DB로 출력된?데이터 사라짐.
				conn.close();
				System.out.println("db 연결 해제");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
