package com.fastcampus.biz.board;

public class GetBoardClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		boardDAO.getBoard(1);
		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			String sql = "select * from board where seq = ?";
//			stmt= conn.prepareStatement(sql);
//			
//			stmt.setInt(1, Integer.parseInt(args[0]));
//			
//			rs = stmt.executeQuery();
//			
//			if(rs.next()) {
//				System.out.println("��ȣ : " + rs.getInt("SEQ"));
//				System.out.println("���� : " + rs.getString("TITLE"));
//				System.out.println("�ۼ��� : " + rs.getString("WRITER"));
//				System.out.println("���� : " + rs.getString("CONTENT"));
//				System.out.println("����� : " + rs.getDate("REGDATE"));
//				System.out.println("��ȸ�� : " + rs.getInt("CNT"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
		
	}
	
}