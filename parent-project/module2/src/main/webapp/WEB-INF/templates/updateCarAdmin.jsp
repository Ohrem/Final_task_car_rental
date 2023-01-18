<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<c:import url="_header.jsp"/>
<div class="container" style="margin-top: 10px">
    <div class="col-md-6 mx-auto">
        <div class="row" style="margin: 10px 0 0">
            <h1 style="padding: 0;">
                Update car
            </h1>
        </div>
        <div class="row" style="margin-top: 10px">
            <form class="row g-3" action="/hello/updateCarAdmin.html" method="post" onsubmit="return confirm('Обновить?')" enctype="multipart/form-data">
                <input type="hidden" name="carId" value="${carId}">
                <div class="col-6">
                    <label for="inputPhoto" class="form-label">Car photo</label>
                    <input name="photo" type="file" class="form-control" id="inputPhoto" placeholder="car_photo.jpg"
                           required accept="image/*"/>
                </div>
                <div class="col-6">
                    <label for="inputBrand" class="form-label">Brand</label>
                    <input name="brand" type="text" class="form-control" id="inputBrand" placeholder="Volvo" required
                           pattern="^([A-Za-z]{1,18})$"/>
                </div>
                <div class="col-6">
                    <label for="inputModel" class="form-label">Model</label>
                    <input name="model" type="text" class="form-control" id="inputModel" placeholder="XC90"
                           pattern="^[a-zA-Z0-9]+$" required/>
                </div>
                <div class="col-6">
                    <label for="inputColor" class="form-label">Color</label>
                    <input name="color" type="text" class="form-control" id="inputColor" placeholder="black"
                           pattern="^([A-Za-z]{1,10})$" required/>
                </div>
                <div class="col-8">
                    <label for="inputPrice" class="form-label">Price per hour ($)</label>
                    <input name="price" type="number" class="form-control" id="inputPrice"
                           pattern="^[0-9\.]"
                           title="Must contain num and ."
                           required/>
                </div>
                <div class="col-2">
                    <label for="inputTrueRadio" class="form-label">Available</label>
                    <input name="isAvailable" type="radio" class="form-control" value="true" id="inputTrueRadio"checked />
                </div>
                <div class="col-2">
                    <label for="inputRadio" class="form-label">Not available</label>
                    <input name="isAvailable" type="radio" class="form-control" value="false" id="inputRadio"/>
                </div>
                <div class="col-12">
                    <label for="inputDescription" class="form-label">Car description</label>
                    <input name="description" type="text" class="form-control" id="inputDescription" placeholder="description" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" style="width: 100%">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>











<%--<form method="post" action="/hello/updateCarAdmin.html" enctype="multipart/form-data">--%>
<%--    <input type="hidden" name="carId" value="${carId}">--%>
<%--    <input name="photo" type="file" class="form-control" id="inputPhoto" placeholder="car_photo.jpg"--%>
<%--           required accept="image/*"/>--%>
<%--    <input type="text" name="brand">--%>
<%--    <input type="text" name="model">--%>
<%--    <input type="text" name="color">--%>
<%--    <input type="number" name="price">--%>
<%--    <input type="text" name="description">--%>

<%--    <label for="inputTrueRadio" class="form-label">Available</label>--%>
<%--    <input name="isAvailable" type="radio" class="form-control" value="true" id="inputTrueRadio" checked/>--%>
<%--    <label for="inputRadio" class="form-label">Not available</label>--%>
<%--    <input name="isAvailable" type="radio" class="form-control" value="false" id="inputRadio"/>--%>

<%--    <button type="submit">Submit</button>--%>
<%--</form>--%>
</html>
