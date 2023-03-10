<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car rental index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a href="/hello/index.html">
        <img src="${pageContext.request.contextPath}/resources/imgs/67-670378_car-image-rent-a-car-logo.png"
             alt="" width="120" height="50"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/hello/index.html">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Cars
                    </a>
                    <security:authorize access="hasRole('ADMIN')">
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/hello/car-list.html?page=1">Show cars</a></li>
                        </ul>
                    </security:authorize>
                    <security:authorize access="hasRole('USER')">
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/hello/car-list-user.html?page=1">Show cars</a></li>
                        </ul>
                    </security:authorize>
                    <security:authorize access="hasRole('ANONYMOUS')">
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/hello/car-list-user.html?page=1">Show cars</a></li>
                        </ul>
                    </security:authorize>
                </li>

                <li class="nav-item dropdown">
                    <security:authorize access="isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </security:authorize>
                </li>
                <li class="nav-item dropdown">
                    <security:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="/hello/register.html">Register</a>
                    </security:authorize>
                    <security:authorize access="hasRole('USER')">
                        <a class="nav-link" href="/hello/myProfile.html">My profile</a>
                    </security:authorize>
                </li>
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            ADMIN PANEL
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/hello/user-list.html?page=1">ADMIN User changes</a></li>
                            <li><a class="dropdown-item" href="/hello/car-list.html?page=1">ADMIN Car changes</a></li>
                            <li><a class="dropdown-item" href="/hello/order-list.html?page=1">ADMIN Order changes</a>
                            </li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
            <img src="${pageContext.request.contextPath}/resources/imgs/user_icon_150670.png" alt="" width="25"
                 height="25"/>
            <security:authorize access="isAuthenticated()">
                <a class="nav-link disabled">Welcome&nbsp;<security:authentication property="name"/>&nbsp; </a>
            </security:authorize>
            <security:authorize access="!isAuthenticated()">
                <a class="nav-link disabled">Welcome&nbsp;anonymous </a>
            </security:authorize>

        </div>
    </div>
</nav>
</body>
</html>
