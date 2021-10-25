package com.fastcampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fastcampus.biz.common.JDBCUtil;

public class GetBoardListClient {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from board where seq = ?";
			stmt= conn.prepareStatement(sql);
			
			stmt.setInt(1, Integer.parseInt(args[0]));
			
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
