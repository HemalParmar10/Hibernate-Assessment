<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="container">
		<h2>Register</h2>

		<form action="<%=request.getContextPath()%>/register" method="post">
			<input name="name" placeholder="Name"> <input name="email"
				placeholder="Email"> <input type="password" name="password"
				placeholder="Password">
			<button>Register</button>
		</form>

		<div class="error">
			<%=request.getParameter("error") != null ? "Email already exists" : ""%>
		</div>

		<p>
			Already have an account? <a href="login.jsp">Login</a>
		</p>
	</div>

</body>
</html>
