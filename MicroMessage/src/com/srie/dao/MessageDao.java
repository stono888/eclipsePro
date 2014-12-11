package com.srie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.srie.bean.Message;

/**
 * 和message表相关的操作都在这里
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessagList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.1.187.163:1521:ora11g1";
			String user = "orga1";
			String password = "orga1";
			conn = DriverManager.getConnection(url, user, password);
			StringBuilder sql = new StringBuilder(
					"select id,command,description,content from message where 1=1");
			List<String> paramList = new ArrayList<String>();
			if (command != null && !"".equals(command.trim())) {
				sql.append(" and command=? ");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and description like '%'|| ? ||'%' ");
				paramList.add(description);
			}
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("id"));
				message.setCommand(rs.getString("command"));
				message.setDescription(rs.getString("description"));
				message.setContent(rs.getString("content"));
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return messageList;
	}
}
