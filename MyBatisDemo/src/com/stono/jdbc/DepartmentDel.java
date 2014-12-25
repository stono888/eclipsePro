package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����ɾ���࣬���ݲ���id���в��ű�ɾ�������ɾ���ļ�¼����
 */
public class DepartmentDel {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// ���в��ż�¼ɾ��
			deleteDep(conn, 21);
			// ���ݿ����ӹر�
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
	 * ���ݲ���id���в��ż�¼��ɾ��
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
		// ����sql���������
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate + " rows department deleted.");
		ps.close();
	}

}
