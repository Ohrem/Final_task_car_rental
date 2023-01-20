<%--
  Created by IntelliJ IDEA.
  User: evgeniy.hozhaynov
  Date: 19.01.2023
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/hello/updateOrderAdmin.html">
    <input type="hidden" name="orderId" value="${orderId}">
    <input type="date" name="beginDate">
    <input type="date" name="endDate">
    <input type="text" name="message">
    <input type="submit" value="Submit">
</form>

</body>
</html>
