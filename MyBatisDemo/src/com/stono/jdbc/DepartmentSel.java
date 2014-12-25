package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询部门的数据信息
 */
public class DepartmentSel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 显示部门的信息
			showDep(conn);
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
	 * 查询部门的信息
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void showDep(Connection conn) throws SQLException {
		String sql;
		PreparedStatement ps;
		ResultSet resultSet;
		sql = "select t.name,t.content1,t.time1,t.id from department t order by t.id";
		ps = conn.prepareStatement(sql);
		resultSet = ps.executeQuery();
		while (resultSet.next()) {
			String name = resultSet.getString(1);
			String content1 = resultSet.getString(2);
			String time1 = resultSet.getString(3);
			String id = resultSet.getString(4);
			System.out.println(id + "\t" + name + "\t" + content1 + "\t"
					+ time1);
		}
		resultSet.close();
		ps.close();
	}
}
