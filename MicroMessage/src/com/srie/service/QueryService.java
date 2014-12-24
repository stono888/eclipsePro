package com.srie.service;

import java.util.List;
import java.util.Random;

import com.srie.bean.Command;
import com.srie.bean.CommandContent;
import com.srie.bean.Message;
import com.srie.dao.CommandDao;
import com.srie.dao.MessageDao;
import com.srie.util.Iconst;

/**
 * 查询相关的业务功能 列表相关的业务功能
 */
public class QueryService {
	public List<Message> queryMessagList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessagList(command, description);
	}

	/**
	 * 通过指令查询自动回复的内容
	 * 
	 * @param command
	 *            指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao messageDao = new CommandDao();
		List<Command> commandList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			commandList = messageDao.queryCommandList(null, null);
			StringBuilder builder = new StringBuilder();
			for (Command message : commandList) {
				builder.append("回复[" + message.getName() + "]查看"
						+ message.getDescription() + "<br>");
			}
			return builder.toString();
		}
		commandList = messageDao.queryCommandList(command, null);
		if (commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0)
					.getContentList();
			int nextInt = new Random().nextInt(contentList.size());
			return contentList.get(nextInt).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}

	/**
	 * 通过指令查询自动回复的内容
	 * 
	 * @param command
	 *            指令
	 * @return 自动回复的内容
	 */
	public String queryByCommandOld(String command) {
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryMessagList(null, null);
			StringBuilder builder = new StringBuilder();
			for (Message message : messageList) {
				builder.append("回复[" + message.getCommand() + "]查看"
						+ message.getDescription() + "<br>");
			}
			return builder.toString();
		}
		messageList = messageDao.queryMessagList(command, null);
		if (messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
