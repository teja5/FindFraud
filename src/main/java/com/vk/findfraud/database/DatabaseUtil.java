package com.vk.findfraud.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vk.findfraud.database.model.Fraud;
import com.vk.findfraud.database.model.Proof;
import com.vk.findfraud.database.model.User;

public class DatabaseUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildFactory() {

		Configuration configuration = new Configuration().addAnnotatedClass(Fraud.class).addAnnotatedClass(Proof.class)
				.addAnnotatedClass(User.class).configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildFactory();
		return sessionFactory;
	}
}
