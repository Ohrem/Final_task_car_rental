<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>All Cars</title>
</head>
<body>
<header>
    <jsp:include page="_header.jsp"/>
</header>
<div class="container">
    <div class="col-md-12">
        <div class="row" style="margin: 50px 0">
            <h1 style="padding: 0">All cars </h1>
        </div>
        <div class="row">
            <table class="table table-light table-bordered align-middle table table-striped"
                   style="background-color: #d1e7dd">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Brand</th>
                    <th scope="col">Price</th>
                    <th scope="col">Photo</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr style="width:100%">
                        <td><c:out value="${car.id}"/></td>
                        <td><c:out value="${car.brand}"/></td>
                        <td><c:out value="${car.price}"/></td>
                        <td>
                            <image src="/hello/image/${car.id}/carPhoto.jpg" class="img-car"
                                   style="width: 150px; height: 80px"></image>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<form action="index.html">
    <input type="submit" value="Home" class="btn btn-primary btn-sm" style="width: 20%"/>
</form>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="car-list-user.html?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table>
    <tr>
        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td><c:out value="${i}"/></td>
                </c:when>
                <c:otherwise>
                    <td><a href="car-list-user.html?page=${i}"><c:out value="${i}"/></a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt numberOfPages}">
    <td><a href="car-list-user.html?page=${currentPage + 1}">Next</a></td>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>