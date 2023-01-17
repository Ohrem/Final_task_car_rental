<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">--%>
    <title>All Users</title>
</head>
<body>
<header>
    <jsp:include page="_header.jsp"/>
</header>
<div class="container">
    <div class="col-md-12">
        <div class="row" style="margin: 50px 0">
            <h1 style="padding: 0">All registered users </h1>
        </div>
        <form method="get" action="/hello/add-user.html">
            <input class="dropdown-item" type="submit" value="Add user">
        </form>
        <div class="row">
            <table class="table table-light table-bordered align-middle table table-striped"
                   style="background-color: #d1e7dd">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Balance</th>
                    <th scope="col">Photo</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr style="width:100%">
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.balance}"/></td>
                        <td>
                            <image src="/hello/image/${user.id}/userPhoto.jpg" class="img-user"
                                   style="width: 80px; height: 80px"></image>
                        </td>
                        <td>
                            <div class="btn-group dropend">
                                <button type="button" class="btn btn-sm btn-success dropdown-toggle"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                    Actions
                                </button>
                                <ul class="dropdown-menu" style="">
                                    <li>
                                        <form method="get" action="/hello/${user.id}/updateUserAdmin.html">
                                            <input type="hidden" name="user_id" value="${user.id}">
                                            <input class="dropdown-item" type="submit" value="Update">
                                        </form>
                                    </li>
                                    <li>
                                        <form method="get" action="/hello/${user.id}/deleteUserAdmin.html">
                                            <input type="hidden" name="user_id" value="${user.id}">
                                            <input class="dropdown-item" type="submit" value="Delete">
                                        </form>
                                    </li>
                                    <li>
                                        <form method="get" action="/hello/${user.id}/viewUserAdmin.html">
                                            <input type="hidden" name="user_id" value="${user.id}">
                                            <input class="dropdown-item" type="submit" value="View user">
                                        </form>
                                    </li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>