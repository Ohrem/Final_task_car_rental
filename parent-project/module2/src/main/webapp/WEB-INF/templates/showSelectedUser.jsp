<%--
  Created by IntelliJ IDEA.
  User: evgeniy.hozhaynov
  Date: 17.01.2023
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Name: ${name}
Surname: ${surname}
Email: ${email}
Phone: ${phone}
Role: ${role}
Balance: ${balance}
Photo: <image src="/hello/image/${userId}/userPhoto.jpg" class="img-car"
              style="width: 120px; height: 80px"></image>
</body>
</html>
