package spms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import spms.dto.MemberDto;

//데이터베이스에 관한 클래스 Dao
public class MemberDao {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

//회원 조회
	public List<MemberDto> selectList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();

		String sql = "";

		sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE" + " FROM MEMBERS" + " ORDER BY MNO ASC";

		try {

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			int no = 0;
			String name = "";
			String email = "";
			Date creDate = null;

			while (rs.next()) {
				no = rs.getInt("MNO");
				name = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");

				MemberDto memberDto = new MemberDto(no, name, email, creDate);

				memberList.add(memberDto);
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally end
		return memberList;
	}

	// 회원 추가
	public int memberInsert(MemberDto memberDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String email = memberDto.getEmail();
			String pwd = memberDto.getPassword();
			String name = memberDto.getName();

			String sql = "INSERT INTO MEMBERS" + "(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE)"
					+ "VALUES(MEMBERS_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally 종료
		return result;
	}

	// 회원 삭제
	public int delete(int no) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "";

		try {
			sql = "DELETE FROM MEMBERS";// 멤버삭제구문
			sql += " WHERE MNO = ?";

			pstmt = connection.prepareStatement(sql);// DB에 구문 넣음

			pstmt.setInt(1, no);// mNo값을 ?에 대입

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally 종료
		return result;
	}

	// 회원 상세정보 조회

	public MemberDto selectOne(int no) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberDto memberDto = new MemberDto();
		String sql = "";

		sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE";
		sql += " FROM MEMBERS";
		sql += " WHERE MNO =?";

		pstmt = connection.prepareStatement(sql);

		try {

			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			Date creDate = null;

			if (rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");

				memberDto.setNo(no);
				memberDto.setName(mName);
				memberDto.setEmail(email);
				memberDto.setCreatedDate(creDate);
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally 종료
		return memberDto;
	}

	public MemberDto update(MemberDto memberDto) {
		PreparedStatement pstmt = null;
		String sql = "";

		String email = memberDto.getEmail();
		String name = memberDto.getName();
		int mNo = memberDto.getNo();

		try {

			sql = "UPDATE MEMBERS";
			sql += " SET EMAIL=?, MNAME=?, MOD_DATE=SYSDATE";
			sql += " WHERE MNO =?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setInt(3, mNo);
			
	

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // finally 종료
		return memberDto;
	}
	
	public MemberDto exist(String email, String pwd) {
		String sql ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;

		try {
			sql += "SELECT EMAIL, MNAME";
			sql += " FROM MEMBERS";
			sql += " WHERE EMAIL = ? AND PWD = ?";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setEmail(email);
				memberDto.setPassword(pwd);
			
				System.out.println("정보전달 성공");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("로그인 정보 전달 실패");
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return memberDto;
	}

}
