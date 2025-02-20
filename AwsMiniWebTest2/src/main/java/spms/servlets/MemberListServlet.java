package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/member/list")
@SuppressWarnings("serial")
public class MemberListServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ServletContext sc = this.getServletContext();

	      String driver = sc.getInitParameter("driver");
	      String url = sc.getInitParameter("url");
	      String user = sc.getInitParameter("user");
	      String password = sc.getInitParameter("password");
	   

		try {
//			1JDBC 드라이버 등록
			Class.forName(driver);
//			2DB연결
			conn = DriverManager.getConnection(url, user, password);
//			3SQL 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
					+ " FROM MEMBERS"
					+ " ORDER BY MNO ASC";
//			4DB에 sql문 보내기
			rs = stmt.executeQuery(sql);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter();

			String htmlStr = "";
			
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";
			
			out.println("<!DOCTYPE html><html>");
			out.println("<head><meta charset=\"UTF-8\">");
			out.println("<title>회원목록</title></head>");
			out.println("<body>");
			
			out.println("<h1>회원목록</h1>");
			out.println(htmlStr);
			
//			5.데이터 활용
			while (rs.next() == true) {
				out.println(
					rs.getInt("MNO") + "," +
					"<a href='./update?mNo=" +
						rs.getInt("MNO") +
					"'>" + 	
					rs.getString("MNAME") + "</a>," +
					rs.getString("EMAIL") + "," +
					rs.getString("CRE_DATE") + "<br>"
				);
			}
			
			out.println("</body></html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//		6jdbc 객체 메모리 회수	
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		} // finally
		
		
	}

	
	
}
