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
		testUpdate4();
	}

	private static void testUpdate4() {
		Configuration configure = new Configuration().configure();
		// hibernate4推荐实现服务注册方式进行SessionFactory获取
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// 持久化对象在更新的时候尅不需要显示的调用update()方法
		// 持久化状态对象会在session关闭的时候如果内存数据和表数据不一致将自动同步到数据库表；
		// Person person = (Person) session.get(Person.class, 5);//这个也是持久化对象，
		Person person = new Person();// 这是个临时对象；

		person.setId(5);
		person.setName("admin1A");
		// 更新
		Person p2 = (Person) session.merge(person);// p2是持久化对象，这两个持久化对象是相同的；
		p2.setName("B");
		person.setName("C"); // 这个是无效的；
		transaction.commit();
		session.close();
	}

	private static void testUpdate3() {
		Configuration configure = new Configuration().configure();
		// hibernate4推荐实现服务注册方式进行SessionFactory获取
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				configure.getProperties()).buildServiceRegistry();
		SessionFactory factory = configure.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// 持久化对象在更新的时候尅不需要显示的调用update()方法
		// 持久化状态对象会在session关闭的时候如果内存数据和表数据不一致将自动同步到数据库表；
		Person person = (Person) session.get(Person.class, 5);
		person.setName("tom9999");
		// 更新
		// session.update(person);
		transaction.commit();
		session.close();
	}

}
