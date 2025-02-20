package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spms.dto.MemberDto;


@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			// TODO Auto-generated method stub
		Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      ServletContext sc = this.getServletContext();
	      
	      String driver = sc.getInitParameter("driver");
	      String url = sc.getInitParameter("url");
	      String user = sc.getInitParameter("user");
	      String password = sc.getInitParameter("password");
	      
//	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	      String user = "edu";
//	      String password = "edu12";
	      

	      try {
//	         1JDBC 드라이버 등록
	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	         2DB연결
	         conn = DriverManager.getConnection(url, user, password);
        
	         String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
	               + " FROM MEMBERS"
	               + " ORDER BY MNO ASC";
	         
//	         3SQL 실행 객체 준비	         
	         pstmt = conn.prepareStatement(sql);
//	         4DB에 sql문 보내기
	         rs = pstmt.executeQuery();
	         
//	         res.setContentType("text/html");
//	         res.setCharacterEncoding("UTF-8");
	         
	         

//	         String htmlStr = "";
//	         
//	         htmlStr += "<p>";
//	         htmlStr += "<a href='./add'>신규 회원";
//	         htmlStr += "</a>";
//	         htmlStr += "</p>";
//	         
//	         out.println("<!DOCTYPE html><html>");
//	         out.println("<head><meta charset=\"UTF-8\">");
	         
	         ArrayList<MemberDto> memberList =new ArrayList<>();
	         
	         int mno =0;
	         String mname="";
	         String email ="";
	         Date creDate = null;
	         
//	         out.println("<title>회원목록</title></head>");
//	         out.println("<body>");
//	         
//	         out.println("<h1>회원목록</h1>");
//	         out.println(htmlStr);
	         
//	         5.데이터 활용
	         while (rs.next() == true) {
	        	 
	        	 mno = rs.getInt("MNO");
	        	 mname = rs.getString("MNAME");
	        	 email = rs.getString("EMAIL") ;
	        	 creDate =rs.getDate("CRE_DATE");
	        	 
	        	MemberDto memberDto = new MemberDto(mno,mname, email, creDate);
	        	
	        	memberList.add(memberDto);
	         }
	         
	         req.setAttribute("memberList", memberList);
	         
	         RequestDispatcher dispatcher= 
	        		 req.getRequestDispatcher("/member/MemberListView.jsp");
	         
	         dispatcher.include(req,res);
//	            out.println(
//	               rs.getInt("MNO") + "," +
//	               "<a href='./update?mNo=" + 
//	                     rs.getInt("MNO") + 
//	               "'>" +
//	               rs.getString("MNAME") + "</a>," +
//	               rs.getString("EMAIL") + "," + 
//	               rs.getDate("CRE_DATE") + 
//	               "<a href='./delete?mNo=" + 
//	                  rs.getInt("MNO") + 
//	               "'>[삭제]</a>" + 
//	               "<br>"
//	            );
	         
	         
//	         out.println("</body></html>");
	      }catch (Exception e) {
	    	  throw new ServletException(e);
	      }finally {
	    	  if(rs!=null) {
	    		  try {
	    			  rs.close();
	    			  System.out.println("ResultSet 종료");
	    	  }catch (SQLException e) {
//	 	          TODO Auto-generated catch block
	 	         e.printStackTrace();
	      }
//	      } catch (ClassNotFoundException e) {
//	         // TODO Auto-generated catch block
//	       //  e.printStackTrace();
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }finally {
////	      6jdbc 객체 메모리 회수   
//	         if(rs != null) {
//	            try {
//	               rs.close();
//	            } catch (SQLException e) {
//	               // TODO: handle exception
//	               e.printStackTrace();
//	            }
//	         }
//	         
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	               
	            } catch (SQLException e) {
	               // TODO: handle exception
	            	System.out.println("preparedStatement(쿼리) 종료");
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	               System.out.println("connection(db) 연결 종료");
	            } catch (SQLException e) {
	               // TODO: handle exception
	               e.printStackTrace();
	            }
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
