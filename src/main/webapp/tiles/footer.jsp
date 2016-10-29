<div id="footer">
    <div>My footer text</div>
    <div class="menu">
        <ul class="nav nav-tabs nav-justified">
            <security:authorize access="!isAuthenticated()">
                <li><a href="/loginForm">Login</a></li>
                <li><a href="/signin">Sign in</li>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
                <li><a href="/logout">Logout</a><br/></li>
            </security:authorize>
        </ul>
    </div>
</div>