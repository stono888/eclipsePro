package com.srie.service;

import java.util.ArrayList;
import java.util.List;

import com.srie.dao.MessageDao;

/**
 * 维护相关的业务功能
 */
public class MaintainService {

	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {

			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}

	}

	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) {
		if (ids == null || ids.length < 1) {
			return;
		}
		List<Integer> integers = new ArrayList<Integer>();
		for (String string : ids) {
			integers.add(Integer.valueOf(string));
		}
		MessageDao messageDao = new MessageDao();
		messageDao.deleteBatch(integers);
	}
}
