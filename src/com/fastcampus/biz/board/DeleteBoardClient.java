package com.fastcampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fastcampus.biz.common.JDBCUtil;

public class DeleteBoardClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		boardDAO.deleteBoard(vo);
		
		boardDAO.getBoardList(vo);
		
		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			String sql = "delete board where seq = ?";
//			stmt= conn.prepareStatement(sql);
//			
//			stmt.setInt(1, 3);
//			
//			int count = stmt.executeUpdate();
//			System.out.println(count + "건의 데이터 처리 성공!!!");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
		
	}
	
}
