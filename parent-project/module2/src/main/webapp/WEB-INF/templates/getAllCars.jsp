<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table style="width:100%" class="table">
  <tr style="width: 100%">
    <th>ID</th>
    <th>Brand</th>
    <th>Price</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${cars}" var="car">
    <tr style="width: 100%">
      <td><c:out value="${car.id}"/></td>
      <td><c:out value="${car.brand}"/></td>
      <td><c:out value="${car.price}"/></td>
      <td><image src="/hello/image/${car.id}/carPhoto.jpg" class="img-thumbnail" style="width: 180px; height: 100px"/></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>