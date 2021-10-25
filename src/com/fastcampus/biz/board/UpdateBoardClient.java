package com.fastcampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fastcampus.biz.common.JDBCUtil;

public class UpdateBoardClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		vo.setTitle("제목 수정");
		vo.setContent("내용 수정");

		boardDAO.updateBoard(vo);
		
		boardDAO.getBoardList();
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			String sql = "update board set title = ?, content = ? where seq = ?";
//			stmt= conn.prepareStatement(sql);
//			
//			stmt.setString(1, "제목 수정");
//			stmt.setString(2, "내용 수정");
//			stmt.setInt(3, 3);
//			
//			int count = stmt.executeUpdate();
//			System.out.println(count + "건의 데이터 처리 성공!!!");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
		
	}
	
}
