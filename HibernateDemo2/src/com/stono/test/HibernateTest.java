package com.stono.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stono.pojo.Person;

public class HibernateTest {

	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;

	/**
	 * 测试之前初始化数据
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("-----测试之前初始化数据--------");
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(sr);
		session = sessionFactory.openSession();
	}

	/**
	 * 测试之后释放数据
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("------测试之后释放数据------------");
		if (session.isOpen()) {
			session.close();
		}
	}

	@Test
	public void testAdd() {
		Person person = new Person("admin", 123456, new Date());
		transaction = session.beginTransaction();
		session.persist(person);
		transaction.commit();
	}
}
