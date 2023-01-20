<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    <title>All Users</title>
</head>
<body>
<header>
    <jsp:include page="_header.jsp"/>
</header>
<div class="container">
    <div class="col-md-12">
        <div class="row" style="margin: 20px 0">
            <h1 style="padding: 0">All registered users </h1>
        </div>
        <div class="row">
            <table class="table table-light table-bordered align-middle table table-striped"
                   style="background-color: #d1e7dd">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Balance</th>
                    <th scope="col">Photo</th>
                    <th scope="col"></th>
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

<div class="pagination">
    <c:if test="${currentPage != 1}">
        <td style="font-weight: bold; font-size: large; margin-right: 10px"><a class="previous"
                href="user-list.html?page=${currentPage - 1}" style="color: mediumblue; font-size: large">Previous</a></td>
    </c:if>

    <table class="" style="width: 15%">
        <tr style="font-weight: bold; font-size: large;">
            <c:forEach begin="1" end="${numberOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td style="font-weight: bold; font-size: large; margin-right: 10px"><c:out value="${i}"/></td>
                    </c:when>
                    <c:otherwise>
                        <td style="font-weight: bold; font-size: large; margin-right: 10px"><a
                                href="user-list.html?page=${i}"><c:out value="${i}"/></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <c:if test="${currentPage lt numberOfPages}">
        <td style="font-weight: bold; font-size: large; margin-right: 10px"><a
                href="user-list.html?page=${currentPage + 1}" style="color: mediumblue; font-size: large">Next</a></td>
    </c:if>
</div>

<div class="back-home-util" style="width: 10%;margin-left: 79%; margin-top: -25px">
    <form action="index.html">
        <input type="submit" value="Home" class="btn btn-primary btn-sm" style="width: 100%"/>
    </form>
</div>
<div class="add-user-util" style="width: 10%; margin-left: 11%; margin-top: -50px; ">
    <form action="add-user.html">
        <input type="submit" value="Add user" class="btn btn-primary btn-sm active" style="width: 100%"/>
    </form>
</div>
<hr style="color: white">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>