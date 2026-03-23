<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create Post</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="container">

		<div class="navbar">
			<a href="home.jsp">Home</a> <a href="<%=request.getContextPath()%>/logout">Logout</a> <a
				href="<%=request.getContextPath()%>/recent">Recent Posts</a>
		</div>

		<h2>Create Blog Post</h2>

		<form action="<%=request.getContextPath()%>/createPost" method="post">
			<input name="title" placeholder="Title">
			<textarea name="content" placeholder="Content"></textarea>
			<input name="tags" placeholder="Tags">
			<button>Create</button>
		</form>

	</div>

</body>
</html>
