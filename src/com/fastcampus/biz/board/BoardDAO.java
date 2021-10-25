package com.fastcampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fastcampus.biz.common.JDBCUtil;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)" +
										"values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	public void insertBoard(String title, String writer, String content) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, title);
			stmt.setString(2, writer);
			stmt.setString(3, content);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBoard(String title, String content, int seq) {
		
	}

	public void deleteBoard(int seq) {
	
	}
	
	public void getBoard(int seq) {
		
	}
	
	public void getBoardList() {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("번호 : " + rs.getInt("SEQ"));
				System.out.println("제목 : " + rs.getString("TITLE"));
				System.out.println("작성자 : " + rs.getString("WRITER"));
				System.out.println("내용 : " + rs.getString("CONTENT"));
				System.out.println("등록일 : " + rs.getDate("REGDATE"));
				System.out.println("조회수 : " + rs.getInt("CNT"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
}
