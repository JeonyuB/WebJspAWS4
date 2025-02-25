package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import spms.dto.MemberDto;

@WebServlet("/member/delete")
@SuppressWarnings("serial")
public class MemberDeleteServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   
	   req.setCharacterEncoding("UTF-8");

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      
      ServletContext sc = this.getServletContext();

      String driver = sc.getInitParameter("driver");
      String url = sc.getInitParameter("url");
      String user = sc.getInitParameter("user");
      String password = sc.getInitParameter("password");
      
      int mNo = Integer.parseInt(req.getParameter("mNo"));
      
      String sql = "";
      
      
      
      System.out.println("오라클 드라이버 로드");
      
      
      try {
//        JDBC 6단계
//        Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        
        rs = pstmt.executeQuery();
        if (rs.next()) {
        // 회원정보 특정대상 삭제
	        sql = "DELETE FROM MEMBERS"
	                + " WHERE MNO=?";
	
	        pstmt = conn.prepareStatement(sql);
	
	        pstmt.setInt(1, mNo);
	
	        pstmt.executeUpdate();
        }
        
//        res.sendRedirect("./list");

        
     }  catch (Exception e) {
		// TODO Auto-generated catch block
    	 RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			
 		rd.forward(req, res);
		e.printStackTrace();
	} finally {
        
        if(pstmt != null) {
           try {
              pstmt.close();
           } catch (SQLException e) {
              e.printStackTrace();
           }
        }
        
        if(conn != null) {
           try {
              conn.close();
           } catch (SQLException e) {
              e.printStackTrace();
           }
        }
     }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      // TODO Auto-generated method stub
 
      
      
   }
}
