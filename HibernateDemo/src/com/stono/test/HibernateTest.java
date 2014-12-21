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
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person("admin",123456,new Date());
		session.save(p);
		tx.commit();
		session.close();
		factory.close();
		
		
	}

}
