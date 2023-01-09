<%--
  Created by IntelliJ IDEA.
  User: evgeniy.hozhaynov
  Date: 09.01.2023
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/hello/createOrder.html">
    <input type="date" name="beginDate">
    <input type="date" name="endDate">
    <input type="text" name="message">
    <button type="submit">Submit</button>
</form>
</body>
</html>
