package com.service;

import com.dao.UserDAO;
import com.entity.User;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public boolean register(User user) {

		// check if email already exists
		User existingUser = userDAO.getByEmail(user.getEmail());

		if (existingUser != null) {
			return false; // user already exists
		}

		userDAO.save(user);
		return true;
	}

	public User login(String email, String password) {

		User user = userDAO.getByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}

		return null;
	}
}
