package cn.dw.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123456");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void close(Connection conn, Statement stat) {
		close(conn, stat, null);
	}
	
	public void close(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (stat != null && !stat.isClosed()) {
					stat.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (conn != null && conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
