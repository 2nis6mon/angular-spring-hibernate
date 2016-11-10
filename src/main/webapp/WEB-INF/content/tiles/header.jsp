<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div id="header">
    <div class="logo">My logo</div>
    <h1>My simplon app <small>test purpose only</small></h1>
    <div class="menu">
        <ul class="nav nav-tabs nav-justified">
            <li><a href="/person">Person</a></li>

            <security:authorize access="hasAuthority('ADMIN')">
                <li><a href="/user">User</a></li>
            </security:authorize>
        </ul>
    </div>
</div>