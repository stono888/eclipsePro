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
	 * ����֮ǰ��ʼ������
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("-----����֮ǰ��ʼ������--------");
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(sr);
		session = sessionFactory.openSession();
	}

	/**
	 * ����֮���ͷ�����
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("------����֮���ͷ�����------------");
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
