<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
            <h1 style="padding: 0">All Orders </h1>
        </div>
        <div class="row">
            <table class="table table-light table-bordered align-middle table table-striped"
                   style="background-color: #d1e7dd">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Begin date</th>
                    <th scope="col">End date</th>
                    <th scope="col">Message</th>
                    <th scope="col"></th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr style="width:100%">
                        <td><c:out value="${order.id}"/></td>
                        <td><c:out value="${order.beginDate}"/></td>
                        <td><c:out value="${order.endDate}"/></td>
                        <td><c:out value="${order.message}"/></td>
                        <td>
                            <div class="btn-group dropend">
                                <button type="button" class="btn btn-sm btn-success dropdown-toggle"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                    Actions
                                </button>
                                <ul class="dropdown-menu" style="">
                                    <li>
                                        <form method="get" action="/hello/${order.id}/updateOrderAdmin.html">
                                            <input type="hidden" name="order_id" value="${order.id}">
                                            <input class="dropdown-item" type="submit" value="Update">
                                        </form>
                                    </li>
                                    <li>
                                        <form method="get" action="/hello/${order.id}/deleteOrderAdmin.html">
                                            <input type="hidden" name="order_id" value="${order.id}">
                                            <input class="dropdown-item" type="submit" value="Delete">
                                        </form>
                                    </li>
                                    <li>
                                        <form method="get" action="/hello/${order.id}/viewOrderAdmin.html">
                                            <input type="hidden" name="order_id" value="${order.id}">
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
                href="order-list.html?page=${currentPage - 1}" style="color: mediumblue; font-size: large">Previous</a>
        </td>
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
                                href="order-list.html?page=${i}" style="color: mediumblue; font-size: large"><c:out
                                value="${i}"/></a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <c:if test="${currentPage lt numberOfPages}">
        <td style="font-weight: bold; font-size: large; margin-right: 10px"><a
                href="order-list.html?page=${currentPage + 1}">Next</a></td>
    </c:if>

</div>
<div class="back-home-util" style="width: 10%; margin-top: 10px; margin-left: 79%; margin-top: -24px">
    <form action="index.html">
        <input type="submit" value="Home" class="btn btn-primary btn-sm" style="width: 100%"/>
    </form>
</div>
<hr style=" color:white">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>