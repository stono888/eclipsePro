package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户查询类，获得用户的记录信息
 */
public class PersonSel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 查询用户记录信息
			selectPerson(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * 查询用户记录信息
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void selectPerson(Connection conn) throws SQLException {
		String sql;
		PreparedStatement ps;
		sql = "select id,name,content1,time1,d_id from person order by id ";
		ps = conn.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		while (resultSet.next()) {
			String id = resultSet.getString(1);
			String name = resultSet.getString(2);
			String content1 = resultSet.getString(3);
			String time1 = resultSet.getString(4);
			String d_id = resultSet.getString(5);
			System.out.println(id + "\t" + name + "\t" + content1 + "\t"
					+ time1 + "\t" + d_id);
		}
		resultSet.close();
		ps.close();
	}
}
