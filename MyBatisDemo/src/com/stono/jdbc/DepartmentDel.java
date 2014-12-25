package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 部门删除类，根据部门id进行部门表删除，输出删除的记录条数
 */
public class DepartmentDel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			// 获取数据库连接
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 进行部门记录删除
			deleteDep(conn, 21);
			// 数据库连接关闭
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
	 * 根据部门id进行部门记录的删除
	 * 
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	private static void deleteDep(Connection conn, int id) throws SQLException {
		String sql;
		PreparedStatement ps;
		sql = "delete from department where id=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 保留sql语句输出结果
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate + " rows department deleted.");
		ps.close();
	}

}
