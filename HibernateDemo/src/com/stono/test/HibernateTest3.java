package com.stono.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.stono.pojo.Person;

public class HibernateTest3 {

	public static void main(String[] args) {
		// testUpdate3();
		// testUpdate4();
		testSaveOrUpdate();
	}

	/**
	 * �������߸��£�
	 */
	private static void testSaveOrUpdate() {
		Configuration configure = new Configuration().configure();
		// hibernate4�Ƽ�ʵ�ַ���ע�᷽ʽ����SessionFactory��ȡ
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();// ���Ǹ���ʱ����

//		person.setId(5);
		// person.setId(null); //�������Ϊnull�������������
		// person.setId(50); //���������idû�ж�Ӧ�ļ�¼����������ʧ��
		person.setName("admin1ANULL");
		// �������߸��£�����id�Ƿ���ڣ�id���ھ��Ǹ��£������ھ��Ǹ��£�
		session.saveOrUpdate(person);
		transaction.commit();
		session.close();
	}

	private static void testUpdate4() {
		Configuration configure = new Configuration().configure();
		// hibernate4�Ƽ�ʵ�ַ���ע�᷽ʽ����SessionFactory��ȡ
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// �־û������ڸ��µ�ʱ�򌡲���Ҫ��ʾ�ĵ���update()����
		// �־û�״̬�������session�رյ�ʱ������ڴ����ݺͱ����ݲ�һ�½��Զ�ͬ�������ݿ��
		// Person person = (Person) session.get(Person.class, 5);//���Ҳ�ǳ־û�����
		Person person = new Person();// ���Ǹ���ʱ����

		person.setId(5);
		person.setName("admin1A");
		// ����
		Person p2 = (Person) session.merge(person);// p2�ǳ־û������������־û���������ͬ�ģ�
		p2.setName("B");
		person.setName("C"); // �������Ч�ģ�
		transaction.commit();
		session.close();
	}

	private static void testUpdate3() {
		Configuration configure = new Configuration().configure();
		// hibernate4�Ƽ�ʵ�ַ���ע�᷽ʽ����SessionFactory��ȡ
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// �־û������ڸ��µ�ʱ�򌡲���Ҫ��ʾ�ĵ���update()����
		// �־û�״̬�������session�رյ�ʱ������ڴ����ݺͱ����ݲ�һ�½��Զ�ͬ�������ݿ��
		Person person = (Person) session.get(Person.class, 5);
		person.setName("tom9999");
		// ����
		// session.update(person);
		transaction.commit();
		session.close();
	}

}
