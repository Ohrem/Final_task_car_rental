<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1>Search results:</h1>
<table style="width:100%">
    <tr>
        <th>ID</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Color</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${searchResult}" var="car">
        <tr>
            <td><c:out value="${car.id}"/></td>
            <td><c:out value="${car.brand}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.color}"/></td>
            <td><c:out value="${car.price}"/></td>
        </tr>
    </c:forEach>
</table>
</html>