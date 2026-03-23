<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.BlogPost"%>
<%@ page import="com.util.HibernateUtil"%>
<%@ page import="org.hibernate.Session"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Post</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="container">

		<%
		Long id = Long.parseLong(request.getParameter("id"));

		Session s = HibernateUtil.getFactory().openSession();
		BlogPost p = s.get(BlogPost.class, id);
		%>

		<div class="navbar">
			<a href="home.jsp">Home</a> <a href="<%=request.getContextPath()%>/logout">Logout</a> <a
				href="<%=request.getContextPath()%>/recent">Recent Posts</a>
		</div>

		<h2>Edit Post</h2>

		<form action="<%=request.getContextPath()%>/editPost" method="post">
			<input type="hidden" name="id" value="<%=p.getId()%>"> <input
				name="title" value="<%=p.getTitle()%>">
			<textarea name="content"><%=p.getContent()%></textarea>
			<input name="tags" value="<%=p.getTags()%>">

			<button>Update</button>
		</form>

	</div>

</body>
</html>
