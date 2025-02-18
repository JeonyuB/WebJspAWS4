package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberAddServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		   throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      System.out.println("doGet을 탄다");
      
      res.setContentType("text/html");
      res.setCharacterEncoding("UTF-8");
      
      PrintWriter out = res.getWriter();
      
      String htmlStr = "";
      
      htmlStr +="<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
      		+ "	<title>회원등록</title></head>"
      		+ "<body><h1>회원등록</h1>"
      		+ "	<form action='add' method='post'>"
      		+ "		이름: <input type='text' name='mname'><br>"
      		+ "		이메일: <input type='text' name='email'><br>"
      		+ "		암호: <input type='password' name='password'><br>"
      		+ "		전화번호: <input type='text' name='phone_num'><br>"
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
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement pstmt = null;
		
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "edu";
	      String password = "edu12";
	      
	      String emailStr = req.getParameter("email");
	      String pwdStr = req.getParameter("password");
	      String nameStr = req.getParameter("mname");
	      String phoneStr = req.getParameter("phone_num");
	      
	      try {
//	         JDBC 드라이버 등록
	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         DB연결
	         conn = DriverManager.getConnection(url ,user, password);
	         //SQL 객체준비
	         //String sql=" ";
	         String sql= " INSERT INTO MEMBERS(mno, email, pwd, mname, cre_date, mod_date, PHONE_NUM ) "
	         		+ "VALUES(members_mno_seq.nextval, ?, ?, ?, SYSDATE, SYSDATE, ?)";
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, emailStr);
	         pstmt.setString(2, pwdStr);
	         pstmt.setString(3, nameStr);
	         pstmt.setString(4, phoneStr);
	         
	         pstmt.executeUpdate();
	         
	         res.setContentType("text/html");
	         res.setCharacterEncoding("UTF-8");
	         
	         PrintWriter out = res.getWriter();
	         
	         String htmlStr="";
	         
	         htmlStr +="<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
	           		+ "	<title>회원등록결과</title></head>"
	           		+ "<body><p>등록완료입니다</p>"
	           		+"<button type='button' onclick=\"location.href='./list'\">처음으로 돌아가기</button>"
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
   

