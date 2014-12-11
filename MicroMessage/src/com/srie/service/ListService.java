package com.srie.service;

import java.util.List;

import com.srie.bean.Message;
import com.srie.dao.MessageDao;

/**
 * 列表相关的业务功能
 */
public class ListService {
	public List<Message> queryMessagList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessagList(command, description);
	}
}
