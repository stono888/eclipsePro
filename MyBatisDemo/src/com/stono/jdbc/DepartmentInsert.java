package com.stono.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 进行部门记录的插入类，插入部门的id,name,content1,time1
 */
public class DepartmentInsert {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(ICONN.URL, ICONN.USER,
					ICONN.PASSWORD);
			// 进行部门记录的插入
			insertDep(conn);
			// 进行部门记录的全部展示
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
	 * 插入部门记录
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void insertDep(Connection conn) throws SQLException {
		String sql;
		PreparedStatement ps;
		sql = "insert into department (id,name,content1,time1) values(s_seq.nextval,?,?,?)";
		ps = conn.prepareStatement(sql);
		// 产生一个1000以内的随机整数，作为name的一部分
		int nextInt = (new Random()).nextInt(1000);
		ps.setString(1, "name1." + nextInt);
		ps.setString(2, "content1." + nextInt);
		long time = (new java.util.Date()).getTime();
		// 根据当前时间创建java.sql.Timestamp，进行时间的设置
		ps.setTimestamp(3, new Timestamp(time));
		ps.executeUpdate();
	}

}
