package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserService service = new UserService();
		User user = service.login(email, password);

		if (user != null) {

			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			resp.sendRedirect("jsp/home.jsp");

		} else {
			resp.sendRedirect("jsp/login.jsp?error=Invalid");
		}
	}
}
