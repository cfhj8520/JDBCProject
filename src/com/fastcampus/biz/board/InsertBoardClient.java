package com.fastcampus.biz.board;

public class InsertBoardClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setContent("����");
		vo.setTitle("����");
		vo.setWriter("�ۼ���");
		
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
//			stmt.setString(1, "JDBC �׽�Ʈ");
//			stmt.setString(2, "JDBC �׽�Ʈ");
//			stmt.setString(3, "JDBC �׽�Ʈ");
//			
//			int count = stmt.executeUpdate();
//			System.out.println(count + "���� ������ ó�� ����!!!");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
		
	}
	
}
