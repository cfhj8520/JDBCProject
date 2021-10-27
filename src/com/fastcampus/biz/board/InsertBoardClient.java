package com.fastcampus.biz.board;

public class InsertBoardClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setContent("내용");
		vo.setTitle("제목");
		vo.setWriter("작성자");
		
		boardDAO.insertBoard(vo);
		
		boardDAO.getBoardList(vo);
		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement stmt = null;
		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			String sql = "insert into board(seq, title, writer, content)" +
//					"values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
//			
//			stmt= conn.prepareStatement(sql);
//			
//			stmt.setString(1, "JDBC 테스트");
//			stmt.setString(2, "JDBC 테스트");
//			stmt.setString(3, "JDBC 테스트");
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
