package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MemberListServlet extends GenericServlet {

   @Override
   public void service(ServletRequest req, ServletResponse res) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "edu";
      String password = "edu12";
      
      try {
//         JDBC 드라이버 등록
         Class.forName("oracle.jdbc.driver.OracleDriver");
//         DB연결
         conn = DriverManager.getConnection(url ,user, password);
         //SQL 객체준비
         stmt = conn.createStatement();
         
         String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, PHONE_NUM"
 		 		+" FROM MEMBERS"
 		 		+ " ORDER BY MNO ASC";
         //db에 SQL문 보내기
         rs = stmt.executeQuery(sql);
         
         res.setContentType("text/html");
         res.setCharacterEncoding("UTF-8");
         //객체 가져와서(getWriter) 보냄(out)
         PrintWriter out = res.getWriter();
         
         out.println("<!DOCTYPE html><html>");
         out.println("<head><meta charset=\"UTF-8\"><title>회원목록</title></head>");
         out.println("<body><h1>회원목록</h1>");
         
         
         out.println("<p>");
         out.println("<a href=\"./add\">신규회원</a>");
         out.println("</a>");
         out.println("</p>");
         
         //데이베이스 의존해서 모든 화면 만들음
         while (rs.next() == true) {
        	 out.println(
        			rs.getInt("MNO")+ ", "+
        			rs.getString("MNAME")+ ", "+
        			rs.getString("PHONE_NUM")+ ", "+
        			rs.getString("EMAIL")+ ", "+
        			rs.getString("CRE_DATE")+ "<br>"
        	);
         }
         out.println("</body></html>");
         
      } catch (ClassNotFoundException e) {
         // TODO: handle exception
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO: handle exception
         
      }finally {
//6.jdbc 객체 메모리 회수
    	  if(rs != null) {
    		  try {
    			  rs.close();
    		  }catch (SQLException e) {
				// TODO: handle exception
    			  e.printStackTrace();
			}
    	  }
    	  
    	  if(stmt != null) {
    		  try {
    			  stmt.close();
    		  }catch (SQLException e) {
				// TODO: handle exception
    			  e.printStackTrace();
			}
    	  }
    	  
    	  if(conn != null) {
    		  try {
    			  conn.close();
    		  }catch (SQLException e) {
				// TODO: handle exception
    			  e.printStackTrace();
			}
    	  }
      }
   }

}
