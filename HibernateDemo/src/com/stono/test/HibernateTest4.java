package com.stono.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.stono.pojo.Person;

public class HibernateTest4 {

	public static void main(String[] args) {
		// testDelete();
		testDelete2();
	}

	/**
	 * ɾ����ʱ״̬����
	 */
	private static void testDelete2() {
		Configuration configure = new Configuration().configure();
		// hibernate4�Ƽ�ʵ�ַ���ע�᷽ʽ����SessionFactory��ȡ
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = new Person();
		person.setId(7);
		session.delete(person);

		transaction.commit();
		session.close();
	}

	/**
	 * ɾ���־û�����
	 */
	private static void testDelete() {
		Configuration configure = new Configuration().configure();
		// hibernate4�Ƽ�ʵ�ַ���ע�᷽ʽ����SessionFactory��ȡ
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = (Person) session.load(Person.class, 5);
		session.delete(person);

		transaction.commit();
		session.close();
	}

}
