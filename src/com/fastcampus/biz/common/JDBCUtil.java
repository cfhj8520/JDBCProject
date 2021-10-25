package com.fastcampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new org.h2.Driver());
			
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Statement stmt, Connection conn) {
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			stmt = null;
		}
		
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
	}
}