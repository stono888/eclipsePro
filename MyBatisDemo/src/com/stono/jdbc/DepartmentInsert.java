package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * ���в��ż�¼�Ĳ����࣬���벿�ŵ�id,name,content1,time1
 */
public class DepartmentInsert {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// ���в��ż�¼�Ĳ���
			insertDep(conn);
			// ���в��ż�¼��ȫ��չʾ
			DepartmentSel.showDep(conn);
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
	 * ���벿�ż�¼
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void insertDep(Connection conn) throws SQLException {
		String sql;
		PreparedStatement ps;
		sql = "insert into department (id,name,content1,time1) values(s_seq.nextval,?,?,?)";
		ps = conn.prepareStatement(sql);
		// ����һ��1000���ڵ������������Ϊname��һ����
		int nextInt = (new Random()).nextInt(1000);
		ps.setString(1, "name1." + nextInt);
		ps.setString(2, "content1." + nextInt);
		long time = (new java.util.Date()).getTime();
		// ���ݵ�ǰʱ�䴴��java.sql.Timestamp������ʱ�������
		ps.setTimestamp(3, new Timestamp(time));
		ps.executeUpdate();
	}

}
