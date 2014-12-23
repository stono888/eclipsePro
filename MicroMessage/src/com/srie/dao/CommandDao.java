package com.srie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.srie.bean.Command;
import com.srie.bean.Message;
import com.srie.db.DBAccess;

/**
 * 与指令表对应的数据库操作
 */
public class CommandDao {

	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryCommandList(String name, String description) {
		List<Command> commandList = new ArrayList<Command>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSesstion = null;
		try {
			sqlSesstion = dbAccess.getSqlSesstion();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			// 通过SqlSession执行SQL语句
			commandList = sqlSesstion.selectList("Command.queryCommandList",
					command);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSesstion != null) {
				sqlSesstion.close();
			}
		}
		return commandList;
	}

	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessagList("", "");
		// Logger log;
		// log.debug("debug");
		// log.info("info:");
		// log.warn("war");
		// log.error("err");
	}

	/**
	 * 单条删除
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSesstion();
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * 删除多条
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSesstion();
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessagListJDBC(String command, String description) {
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
