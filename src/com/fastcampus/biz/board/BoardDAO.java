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
	
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			int count = stmt.executeUpdate();
			System.out.println(count + "건의 데이터 처리 성공!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void getBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("번호 : " + rs.getInt("SEQ"));
				System.out.println("제목 : " + rs.getString("TITLE"));
				System.out.println("작성자 : " + rs.getString("WRITER"));
				System.out.println("내용 : " + rs.getString("CONTENT"));
				System.out.println("등록일 : " + rs.getDate("REGDATE"));
				System.out.println("조회수 : " + rs.getInt("CNT"));
			}else {
				System.out.println(vo.getSeq() + "번 게시글은 존재하지 않습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
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
