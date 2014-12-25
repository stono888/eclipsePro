package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ������Ϣɾ����
 */
public class PersonDel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// ɾ��������Ϣ
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
	 * �û����¼ɾ������
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
		// ��¼ɾ���ļ�¼����
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate + " rows person deleted.");
		ps.close();
	}

}
