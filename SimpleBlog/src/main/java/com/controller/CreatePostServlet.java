package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BlogDAO;
import com.entity.BlogPost;
import com.entity.User;

@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		BlogPost post = new BlogPost();
		post.setTitle(req.getParameter("title"));
		post.setContent(req.getParameter("content"));
		post.setTags(req.getParameter("tags"));
		post.setCreatedAt(LocalDateTime.now());
		post.setUser(user);

		new BlogDAO().save(post);
		resp.sendRedirect("jsp/home.jsp");
	}
}
