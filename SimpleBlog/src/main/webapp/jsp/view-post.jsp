<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.BlogPost"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Post</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="container">

		<%
		BlogPost p = (BlogPost) request.getAttribute("post");
		%>

		<div class="navbar">
			<a href="home.jsp">Home</a> <a href="<%=request.getContextPath()%>/logout">Logout</a> <a
				href="<%=request.getContextPath()%>/recent">Recent Posts</a>
		</div>

		<div class="card">
			<h2><%=p.getTitle()%></h2>
			<p><%=p.getContent()%></p>
			<p>
				<b>Tags:</b>
				<%=p.getTags()%></p>
		</div>

	</div>

</body>
</html>
