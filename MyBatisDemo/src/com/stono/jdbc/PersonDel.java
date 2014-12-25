package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 部门信息删除类
 */
public class PersonDel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 删除部门信息
			deletePerson(conn, -1);
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
	 * 用户表记录删除方法
	 * 
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	private static void deletePerson(Connection conn, int id)
			throws SQLException {
		String sql;
		PreparedStatement ps;
		sql = "delete from person where id=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 记录删除的记录条数
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate + " rows person deleted.");
		ps.close();
	}

}
