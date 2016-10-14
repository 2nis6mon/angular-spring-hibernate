<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login page</title>
</head>

<body>
	<form action="${loginUrl}" method="post" class="form-horizontal">
		<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
		<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
		<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		<input type="submit"class="btn btn-block btn-primary btn-default" value="Log in">
	</form>
</body>
</html>