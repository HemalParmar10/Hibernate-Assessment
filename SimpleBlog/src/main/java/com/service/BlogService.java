package com.service;

import java.util.List;

import com.dao.BlogDAO;
import com.entity.BlogPost;

public class BlogService {

	private BlogDAO dao = new BlogDAO();

	public void createPost(BlogPost post) {
		dao.save(post);
	}

	public List<BlogPost> getAllPosts() {
		return dao.getAll();
	}
}
