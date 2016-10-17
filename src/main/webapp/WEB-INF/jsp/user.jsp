<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head>
		<title>Users</title>
	</head>

	<body>
		<h1>Users</h1>
		<h2>Add a user :</h2>
		<form action="/user/add">
			<input type="text" name="username" placeholder="name" />
			<input type="password" name="password" placeholder="surname" />
			<select name="role">
				<option value="USER">USER</option>
				<option value="ADMIN">ADMIN</option>
			</select>
			<input type="submit" value="Add" />
		</form>
		<h1>Users in database :</h1>
		<ul>
			 <c:forEach items="${users}" var="user">
			 	<li>${user.username}&nbsp;:&nbsp;${user.password}&nbsp;${user.enabled}&nbsp;${user.role}
					<a href="/user/delete?id=${user.username}">Delete</a>
				</li>
			 </c:forEach>
		</ul>
		<br/>
		<br/>
		<br/>
		<a href="/">Home</a>
	</body>
</html>