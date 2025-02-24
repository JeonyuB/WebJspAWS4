package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
@SuppressWarnings("serial")
public class MemberAddServlet extends HttpServlet{


@Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		   throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      System.out.println("doGet을 탄다");
      
      res.setContentType("text/html");
      
      
      PrintWriter out = res.getWriter();
      
      String htmlStr = "";
      
      htmlStr +="<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
      		+ "	<title>회원등록</title></head>"
      		+ "<body><h1>회원등록</h1>"
      		+ "	<form action='add' method='post'>"
      		+ "		이름: <input type='text' name='mname'><br>"
      		+ "		이메일: <input type='text' name='email'><br>"
      		+ "		암호: <input type='password' name='password'><br>"
      		+ "		<input type='submit' value='추가'>"
      		+ "		<input type='reset' value='취소'>"
      		+ "	</form></body></html>";
      
      
      out.println(htmlStr);
      
   }
   
   //추가버튼 누르면 do Post 실행
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	   
	   System.out.println("doPost 실행");

		Connection conn =null;
		PreparedStatement pstmt = null;
		
		ServletContext sc = this.getServletContext();

	      String driver = sc.getInitParameter("driver");
	      String url = sc.getInitParameter("url");
	      String user = sc.getInitParameter("user");
	      String password = sc.getInitParameter("password");
	      
	      String emailStr = req.getParameter("email");
	      String pwdStr = req.getParameter("password");
	      String nameStr = req.getParameter("mname");
	      
	      try {
//	         JDBC 드라이버 등록
	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         DB연결
	         conn = DriverManager.getConnection(url ,user, password);
	         //SQL 객체준비
	         //String sql=" ";
	         String sql= " INSERT INTO MEMBERS(mno, email, pwd, mname, cre_date, mod_date ) "
	         		+ "VALUES(members_mno_seq.nextval, ?, ?, ?, SYSDATE, SYSDATE)";
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, emailStr);
	         pstmt.setString(2, pwdStr);
	         pstmt.setString(3, nameStr);
	         
	         pstmt.executeUpdate();
	         
	         res.setContentType("text/html");
	         res.setCharacterEncoding("UTF-8");
	         
	         
	         PrintWriter out = res.getWriter();
	         
	         String htmlStr="";
	         
	         htmlStr +="<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
	        		 +"<meta http-equiv='Refresh' content='1;url=list'>"//등록완료페이지 끝나고 member/list로 이동하게끔 하는 구문 
	           		+ "	<title>회원등록결과</title></head>"
	           		+ "<body><p>등록완료입니다</p>"
	           		+"</body></html>";
	         
	         out.println(htmlStr);
	      }catch(ClassNotFoundException e) {
	    	  e.printStackTrace();
	      }catch(SQLException e) {
	    	  e.printStackTrace();
	      }finally {
	    	  
	    	  if(pstmt !=null) {
	    		  try {
	    			  pstmt.close();
	    			  
	    		  }catch(SQLException e) {
	    			  e.printStackTrace();
	    		  }
	    	  }
	    	  
	    	  if(conn !=null) {
	    		  try {
	    			  conn.close();
	    			  
	    		  }catch(SQLException e) {
	    			  e.printStackTrace();
	    		  }
	    	  }
	      }
   }
}
   

