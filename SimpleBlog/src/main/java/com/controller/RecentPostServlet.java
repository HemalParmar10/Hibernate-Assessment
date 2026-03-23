package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BlogDAO;
import com.entity.BlogPost;

@WebServlet("/recent")
public class RecentPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<BlogPost> posts = new BlogDAO().getRecent();

		req.setAttribute("posts", posts);

		req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
	}
}
