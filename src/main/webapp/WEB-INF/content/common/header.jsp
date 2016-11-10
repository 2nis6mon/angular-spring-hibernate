<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Fixed navbar -->
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">My APP</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/person">Persons</a></li>
                <li><a href="/user">Users</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <li id="nav-profile"><a href="<c:url value="/users" />">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="<c:url value="/logout" />">Sign Out</a></li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<c:url value="/loginForm" />" data-toggle="dropdown">Sign In  <strong class="caret"></strong></a>
                </li>
                    <li class="dropdown">
                    <a class="dropdown-toggle" href="<c:url value="/signup" />" data-toggle="dropdown">Sign Up  <strong class="caret"></strong></a>
                </li>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>