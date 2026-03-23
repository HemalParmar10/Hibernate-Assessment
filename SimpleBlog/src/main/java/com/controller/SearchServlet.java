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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");

		List<BlogPost> posts = new BlogDAO().search(keyword);

		req.setAttribute("posts", posts);

		req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
	}
}
