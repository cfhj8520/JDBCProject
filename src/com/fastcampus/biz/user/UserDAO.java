package com.fastcampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fastcampus.biz.common.JDBCUtil;

public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_INSERT = "insert into user values (?, ?, ?, sysdate, ?)";
	private final String USER_UPDATE = "update users set role = ? where id = ?";
	private final String USER_DELETE = "delete users where id = ?";
	private final String USER_GET = "select * from users where id = ? and password = ?";
	private final String USER_LIST = "select * from users order by id desc";
	
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getRole());
			stmt.setString(2, vo.getId());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			int count = stmt.executeUpdate();
			System.out.println(count + "건의 데이터 처리 성공!!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void getUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
			}else {
				System.out.println(vo.getId() + "의 회원은 존재하지 않습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	public List<UserVO> getBoardList(UserVO vo) {
		List<UserVO> boardList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt= conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("WRITER"));
				user.setContent(rs.getString("CONTENT"));
				user.setRegDate(rs.getDate("REGDATE"));
				user.setRole(rs.getString("ROLE"));
				boardList.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}
