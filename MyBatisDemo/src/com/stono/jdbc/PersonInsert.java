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
 * 用户表插入类；
 */
public class PersonInsert {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 用户表插入调用
			insertPerson(conn);
			// 进行用户表显示
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
	 * 进行用户表插入，插入列为id,name,content1,time1,d_id
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void insertPerson(Connection conn) throws SQLException {
		// 获取所有部门记录的id列表；
		List<Integer> depIds = getDepIds(conn);
		String sql = "insert into person (id,name,content1,time1,d_id) values(s_seq.nextval,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps = conn.prepareStatement(sql);
		// 生成1000以内的随机整数，添加到name记录中；
		int nextInt = (new Random()).nextInt(1000);
		ps.setString(1, "name." + nextInt);
		ps.setString(2, "content1." + nextInt);
		ps.setTimestamp(3, new Timestamp((new java.util.Date()).getTime()));
		// 获取部门记录个数以内的随机整数，用来随机选择部门id；
		int nextInt2 = (new Random()).nextInt(depIds.size());
		ps.setInt(4, depIds.get(nextInt2));
		ps.execute();
		ps.close();
	}

	/**
	 * 获得所有部门记录的id，形成id列表
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
		//循环获得用户id
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			list.add(id);
		}
		resultSet.close();
		ps.close();
		return list;
	}

}
