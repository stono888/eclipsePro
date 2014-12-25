package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * �û�������ࣻ
 */
public class PersonInsert {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// �û���������
			insertPerson(conn);
			// �����û�����ʾ
			PersonSel.selectPerson(conn);
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
	 * �����û�����룬������Ϊid,name,content1,time1,d_id
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void insertPerson(Connection conn) throws SQLException {
		// ��ȡ���в��ż�¼��id�б�
		List<Integer> depIds = getDepIds(conn);
		String sql = "insert into person (id,name,content1,time1,d_id) values(s_seq.nextval,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps = conn.prepareStatement(sql);
		// ����1000���ڵ������������ӵ�name��¼�У�
		int nextInt = (new Random()).nextInt(1000);
		ps.setString(1, "name." + nextInt);
		ps.setString(2, "content1." + nextInt);
		ps.setTimestamp(3, new Timestamp((new java.util.Date()).getTime()));
		// ��ȡ���ż�¼�������ڵ�����������������ѡ����id��
		int nextInt2 = (new Random()).nextInt(depIds.size());
		ps.setInt(4, depIds.get(nextInt2));
		ps.execute();
		ps.close();
	}

	/**
	 * ������в��ż�¼��id���γ�id�б�
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static List<Integer> getDepIds(Connection conn) throws SQLException {
		List<Integer> list = new ArrayList<Integer>();
		String sql = "select id from department";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps = conn.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		//ѭ������û�id
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			list.add(id);
		}
		resultSet.close();
		ps.close();
		return list;
	}

}
