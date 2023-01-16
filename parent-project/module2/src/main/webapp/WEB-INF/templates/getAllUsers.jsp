<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%" class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Balance</th>
        <th>Photo</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr style="width:100%">
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.balance}"/></td>
            <td><image src="/hello/image/${user.id}/photo.jpg" class="img-user" style="width: 80px; height: 80px"></image> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>