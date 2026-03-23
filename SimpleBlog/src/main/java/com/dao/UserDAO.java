package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;
import com.util.HibernateUtil;

public class UserDAO {

	public void save(User user) {
		Session s = HibernateUtil.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}

	public User getByEmail(String email) {
		Session s = HibernateUtil.getFactory().openSession();
		Query<User> q = s.createQuery("FROM User WHERE email=:e", User.class);
		q.setParameter("e", email);
		return q.uniqueResult();
	}
}
