package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.BlogPost;
import com.util.HibernateUtil;

public class BlogDAO {

	public void save(BlogPost post) {
		Session s = HibernateUtil.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(post);
		tx.commit();
		s.close();
	}

	public List<BlogPost> getAll() {
		Session s = HibernateUtil.getFactory().openSession();
		return s.createQuery("FROM BlogPost", BlogPost.class).list();
	}

	public void delete(Long id) {
		Session s = HibernateUtil.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		BlogPost p = s.get(BlogPost.class, id);
		s.delete(p);
		tx.commit();
		s.close();
	}

	public List<BlogPost> search(String keyword) {

		Session s = HibernateUtil.getFactory().openSession();

		Query<BlogPost> q = s.createQuery("FROM BlogPost WHERE title LIKE :kw OR tags LIKE :kw", BlogPost.class);

		q.setParameter("kw", "%" + keyword + "%");

		return q.list();
	}

	public List<BlogPost> getByUser(Long userId) {

		Session s = HibernateUtil.getFactory().openSession();

		Query<BlogPost> q = s.createQuery("FROM BlogPost WHERE user.id = :uid", BlogPost.class);

		q.setParameter("uid", userId);

		return q.list();
	}

	public List<BlogPost> getRecent() {

		Session s = HibernateUtil.getFactory().openSession();

		Query<BlogPost> q = s.createQuery("FROM BlogPost ORDER BY createdAt DESC", BlogPost.class);

		return q.list();
	}

}
