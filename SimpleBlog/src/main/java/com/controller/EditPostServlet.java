package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.BlogPost;
import com.util.HibernateUtil;

@WebServlet("/editPost")
public class EditPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Long id = Long.parseLong(req.getParameter("id"));

		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();

		BlogPost post = session.get(BlogPost.class, id);

		post.setTitle(req.getParameter("title"));
		post.setContent(req.getParameter("content"));
		post.setTags(req.getParameter("tags"));

		session.update(post);

		tx.commit();
		session.close();

		resp.sendRedirect("jsp/home.jsp");
	}
}
