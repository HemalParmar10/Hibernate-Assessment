<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<div class="container">
		<h2>Login</h2>

		<form action="<%=request.getContextPath()%>/login" method="post">
			<input name="email" placeholder="Email"> <input
				type="password" name="password" placeholder="Password">
			<button>Login</button>
		</form>

		<div class="error">
			<%=request.getParameter("error") != null ? "Invalid Credentials" : ""%>
		</div>

		<p>
			Don't have an account? <a href="register.jsp">Register</a>
		</p>
	</div>

</body>
</html>
