package com.stono.mybatis.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �������ݿ���
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		// ͨ�������ļ��õ�java.io.Reader���󣬺������ݿ���Ϣ
		Reader reader = Resources
				.getResourceAsReader("com/stono/mybatis/config/Configuration.xml");
		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		// ����SqlSession�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
