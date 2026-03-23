package com.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		User user = new User();
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));

		UserService service = new UserService();

		if (service.register(user)) {
			resp.sendRedirect("jsp/login.jsp");
		} else {
			resp.sendRedirect("jsp/register.jsp?error=EmailExists");
		}
	}
}
