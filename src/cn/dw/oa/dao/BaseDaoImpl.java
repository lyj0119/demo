package cn.dw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.oa.utils.JdbcUtils;

public abstract class BaseDaoImpl<T> {

	protected abstract T getRow(ResultSet resultSet) throws SQLException;
	
	protected List<T> query(String sql, Object... params) {
		List<T> tList = new ArrayList<T>();
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = jdbcUtils.getConnection();
			preparedStatement =connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tList.add(this.getRow(resultSet));
			}
			return tList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			jdbcUtils.close(connection, preparedStatement, resultSet);
		}
	}
	
	protected int update(String sql, Object... params) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = jdbcUtils.getConnection();
			preparedStatement =connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			jdbcUtils.close(connection, preparedStatement);
		}
	}
	
}
