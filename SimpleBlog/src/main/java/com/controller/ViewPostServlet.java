package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entity.BlogPost;
import com.util.HibernateUtil;

@WebServlet("/viewPost")
public class ViewPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("id"));

		Session session = HibernateUtil.getFactory().openSession();
		BlogPost post = session.get(BlogPost.class, id);

		req.setAttribute("post", post);

		req.getRequestDispatcher("jsp/view-post.jsp").forward(req, resp);
	}
}
