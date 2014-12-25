package com.stono.mybatis.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件得到java.io.Reader对象，含有数据库信息
		Reader reader = Resources
				.getResourceAsReader("com/stono/mybatis/config/Configuration.xml");
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		// 创建SqlSession打开数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
