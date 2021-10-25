package com.fastcampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fastcampus.biz.common.JDBCUtil;

public class UpdateBoardClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt= conn.prepareStatement(sql);
			
			stmt.setString(1, "���� ����");
			stmt.setString(2, "���� ����");
			stmt.setInt(3, 3);
			
			int count = stmt.executeUpdate();
			System.out.println(count + "���� ������ ó�� ����!!!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
}
