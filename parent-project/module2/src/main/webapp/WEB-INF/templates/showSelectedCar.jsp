<%--
  Created by IntelliJ IDEA.
  User: evgeniy.hozhaynov
  Date: 17.01.2023
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
  Brand: ${brand}
  Model: ${model}
  Color: ${color}
  Price: ${price}
  Description: ${description}
  Photo: <image src="/hello/image/${carId}/carPhoto.jpg" class="img-car"
          style="width: 120px; height: 80px"></image>
</body>
</html>
