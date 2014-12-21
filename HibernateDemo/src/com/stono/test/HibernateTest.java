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
		//���Hibernate.cfg.xml�е����ã����ݿ���Ϣ�ȣ�
		Configuration config = new Configuration().configure();
		//���һ�����ӹ�����һ��һ��Ӧ�ó���ֻ��һ��factory��
		//ͨ����Ӧһ�����ݿ⣬ͨ��һ��Ӧ�ó���ֻ��һ������������ʱ�򴴽���
		//�̰߳�ȫ��Ϊ����û�����
		SessionFactory factory = config.buildSessionFactory();
		//���һ��Session��session��Hibernate�ĺ���API����������ɾ�Ĳ鶼��ͨ��Session��ɵģ�
		//session�൱��һ�����ݿ��Ĳ���
		//���̰߳�ȫ��ֻΪһ���û�����
		Session session = factory.openSession();
		//hibernate�е���ɾ����Ҫ�����֧�֣�
		Transaction tx = session.beginTransaction();
		Person p = new Person("admin",123456,new Date());
		//��Person����־û������ݿ�
		session.save(p);
		//�������
		tx.commit();
		//�ر�session
		session.close();
		//�ر�SessionFactory����ʵ���Բ��رյģ�һ������ֻ��һ�������˻����أ�
		factory.close();
		
		
	}

}
