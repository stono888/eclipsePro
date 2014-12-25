package com.stono.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class TestJDBC {

	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url = "jdbc:Oracle:thin:@10.1.187.163:1521:ora11g1";
			String user = "orga1";
			String password = "orga1";
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			String sql = "select * from dual";
			/**
			 * insert into
			 */
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("OK");
			}
			sql = "insert into department (id,content1,time1) values(s_seq.nextval,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "content1");
			ps.setDate(2, new Date((new java.util.Date()).getTime()));
			ps.executeUpdate();
			sql = "insert into person (id,name,content1,time1,d_id) values(s_seq.nextval,?,?,?,"
					+ "(select id from department where content1=? and rownum<2))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "name");
			ps.setString(2, "content1");
			ps.setTime(3, new Time((new java.util.Date()).getTime()));
			ps.setString(4, "content1");
			ps.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
