package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BlogDAO;

@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Long id = Long.parseLong(req.getParameter("id"));

		new BlogDAO().delete(id);

		resp.sendRedirect("jsp/home.jsp");
	}
}
