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

@WebServlet("/filterByUser")
public class FilterByUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long userId = Long.parseLong(req.getParameter("userId"));

		List<BlogPost> posts = new BlogDAO().getByUser(userId);

		req.setAttribute("posts", posts);

		req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
	}
}
