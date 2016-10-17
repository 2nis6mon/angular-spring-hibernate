<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head>
		<title>Persons</title>
	</head>

	<body>
		<h1>Persons :</h1>
		<security:authorize access="isAuthenticated()">
			<h2>Add a person :</h2>
			<form action="/person/add">
				<input type="text" name="name" placeholder="name" />
				<input type="text" name="surname" placeholder="surname" />
				<input type="submit" value="Add" />
			</form>
		</security:authorize>
		<h1>Persons in database :</h1>
		<ul>
			 <c:forEach items="${persons}" var="person">
			 	<li>${person.id}&nbsp;:&nbsp;${person.name}&nbsp;${person.surname}
					<security:authorize access="hasAuthority('ADMIN')">
						&nbsp;<a href="/person/delete?id=${person.id}">Delete</a>
					</security:authorize>
				</li>
			 </c:forEach>
		</ul>
		<br/>
		<br/>
		<br/>
		<security:authorize access="!isAuthenticated()">
			<a href="/loginForm">Login</a><br/>
			<a href="/signin">Sign in</a><br/>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<a href="/logout">Logout</a><br/>
		</security:authorize>
		<security:authorize access="hasAuthority('ADMIN')">
			<a href="/user">Users</a><br/>
		</security:authorize>
		<br/>
	</body>
</html>