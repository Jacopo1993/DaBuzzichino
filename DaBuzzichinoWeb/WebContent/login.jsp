<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>DaBuzzichino LoginPage</h1>
	<form action="${pageContex.request.contextPath}/login" method="POST">
		<input type="text" name="username"/>
		<input type="password" name="password"/>
		<input type="submit" value="Login"/>		
	</form>
</body>
</html>