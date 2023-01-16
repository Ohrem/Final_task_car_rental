<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%" class="table">
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Color</th>
        <th>Price</th>
        <th>Photo</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.id}"/></td>
            <td><c:out value="${car.brand}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.price}"/></td>
            <td><image src="/hello/image/${car.id}/photo.jpg" class="img-thumbnail" style="width: 100px; height: 100px"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>