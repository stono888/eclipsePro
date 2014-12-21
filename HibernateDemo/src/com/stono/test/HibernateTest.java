package com.stono.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.stono.pojo.Person;

public class HibernateTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//获得Hibernate.cfg.xml中的配置，数据库信息等；
		Configuration config = new Configuration().configure();
		//获得一个连接工厂，一般一个应用程序只有一个factory；
		//通常对应一个数据库，通常一个应用程序只有一个，在启动的时候创建；
		//线程安全，为多个用户服务
		SessionFactory factory = config.buildSessionFactory();
		//获得一个Session，session是Hibernate的核心API，其他的增删改查都是通过Session完成的；
		//session相当于一次数据库表的操作
		//非线程安全，只为一个用户服务；
		Session session = factory.openSession();
		//hibernate中的增删改需要事务的支持；
		Transaction tx = session.beginTransaction();
		Person p = new Person("admin",123456,new Date());
		//将Person对象持久化到数据库
		session.save(p);
		//体积事务
		tx.commit();
		//关闭session
		session.close();
		//关闭SessionFactory，其实可以不关闭的，一个程序只有一个，别人还用呢；
		factory.close();
		
		
	}

}
