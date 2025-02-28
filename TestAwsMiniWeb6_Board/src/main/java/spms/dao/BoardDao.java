package spms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spms.dto.BoardDto;
import spms.dto.MemberDto;


public class BoardDao {
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	//게시판 정보 조회-메인 화면에 보여질 리스트
	public List<BoardDto> boardList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();

		String sql = "";

		sql = "SELECT FREE_BOARD_ID, FREE_BOARD_TITLE, FREE_BOARD_CONTENT, "
				+ "CREATE_DATE, MEMBER_NO, UPDATE_DATE "
				+ "FROM FREE_BOARD "
				+ "ORDER BY FREE_BOARD_ID ASC";

		try {

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			int no = 0;
			String title = "";
			String content = "";
			int mNo = 0;
			Date creDate = null;
			Date upDate = null;

			while (rs.next()) {
				no = rs.getInt("FREE_BOARD_ID");
				title = rs.getString("FREE_BOARD_TITLE");
				content = rs.getString("FREE_BOARD_CONTENT");
				content = rs.getString("FREE_BOARD_CONTENT");
				creDate = rs.getDate("CREATE_DATE");
				upDate = rs.getDate("UPDATE_DATE");

				BoardDto boardDto = new BoardDto(no, title, content, mNo, creDate, upDate);

				boardList.add(boardDto);
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
		return boardList;
	}
	

	//게시판 상세 정보 보이기
	public BoardDto boardDetail(int no) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardDto boardDto = new BoardDto();
		String sql = "";

		sql = "SELECT ?, FREE_BOARD_TITLE, FREE_BOARD_CONTENT, "
				+ "CREATE_DATE, MEMBER_NO, UPDATE_DATE "
				+ "FROM FREE_BOARD";

		pstmt = connection.prepareStatement(sql);

		try {

			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			String title = "";
			String content = "";
			Date creDate = null;


			if (rs.next()) {
				title = rs.getString("FREE_BOARD_TITLE");
				content = rs.getString("FREE_BOARD_CONTENT");
				creDate = rs.getDate("CREATE_DATE");

				boardDto.setNo(no);
				boardDto.setTitle(title);
				boardDto.setContent(content);
				boardDto.setCreatedDate(creDate);
			} else {
				throw new Exception("해당 게시물은 존재하지 않습니다.");
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
		return boardDto;
	}

}
