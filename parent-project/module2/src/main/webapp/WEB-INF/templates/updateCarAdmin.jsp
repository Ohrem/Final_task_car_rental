<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/hello/updateCarAdmin.html" enctype="multipart/form-data">
    <input type="hidden" name="carId" value="${carId}">
    <input name="photo" type="file" class="form-control" id="inputPhoto" placeholder="car_photo.jpg"
           required accept="image/*"/>
    <input type="text" name="brand">
    <input type="text" name="model">
    <input type="text" name="color">
    <input type="number" name="price">
    <input type="text" name="description">

    <label for="inputTrueRadio" class="form-label">Available</label>
    <input name="isAvailable" type="radio" class="form-control" value="true" id="inputTrueRadio" checked/>
    <label for="inputRadio" class="form-label">Not available</label>
    <input name="isAvailable" type="radio" class="form-control" value="false" id="inputRadio"/>

    <button type="submit">Submit</button>
</form>
</body>
</html>
