<%@page import="com.entity.BlogPost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entity.BlogPost"%>
<%@ page import="com.entity.User"%>
<%@ page import="com.dao.BlogDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>



	<div class="container">

		<div class="navbar">
			<a href="create-post.jsp">Create Post</a> <a
				href="<%=request.getContextPath()%>/logout">Logout</a> <a
				href="<%=request.getContextPath()%>/recent">Recent Posts</a>
		</div>

		<form action="<%=request.getContextPath()%>/search" method="get">
			<input name="keyword" placeholder="Search by title or tag">
			<button>Search</button>
		</form>
		<br>
		<h2>All Blog Posts</h2>

		<div class="posts">

			<%
			List<BlogPost> posts = (List<BlogPost>) request.getAttribute("posts");

			if (posts == null) {
				posts = new BlogDAO().getAll();
			}

			User currentUser = (User) session.getAttribute("user");

			for (BlogPost p : posts) {
			%>

			<div class="card">
				<a
					href="<%=request.getContextPath()%>/filterByUser?userId=<%=p.getUser().getId()%>">
					More from this user </a>
				<h3><%=p.getTitle()%></h3>
				<p><%=p.getContent()%></p>

				<div class="actions">

					<a href="<%=request.getContextPath()%>/viewPost?id=<%=p.getId()%>">View</a>

					<%
					if (p.getUser().getId().equals(currentUser.getId())) {
					%>

					<a href="edit-post.jsp?id=<%=p.getId()%>">Edit</a> <a
						href="<%=request.getContextPath()%>/deletePost?id=<%=p.getId()%>">Delete</a>

					<%
					}
					%>

				</div>
			</div>

			<%
			}
			%>
		</div>

	</div>

</body>
</html>
