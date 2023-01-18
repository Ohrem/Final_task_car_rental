<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add car</title>
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
        Add car
      </h1>
    </div>
    <div class="row" style="margin-top: 10px">
      <form class="row g-3" action="/hello/add-car.html" method="post" onsubmit="return confirm('Уверены?')" enctype="multipart/form-data">
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
        <div class="col-12">
          <label for="inputModel" class="form-label">Model</label>
          <input name="model" type="text" class="form-control" id="inputModel" placeholder="XC90"
                 pattern="^[a-zA-Z0-9]+$" required/>
        </div>
        <div class="col-12">
          <label for="inputColor" class="form-label">Color</label>
          <input name="color" type="text" class="form-control" id="inputColor" placeholder="black"
                 pattern="^([A-Za-z]{1,10})$" required/>
        </div>
        <div class="col-8">
          <label for="inputPrice" class="form-label">Price per day ($)</label>
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
          <button type="submit" class="btn btn-primary" style="width: 100%">Submit</button>
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
</html>













<%--<form method="post" action="/hello/add-car.html" enctype="multipart/form-data">--%>
<%--  <div class="mb-3">--%>
<%--    <label for="photo" class="form-label">Photo</label>--%>
<%--    <input type="file" name="photo" class="form-control" id="photo">--%>
<%--  </div>--%>
<%--  <div class="mb-3">--%>
<%--    <label for="brand" class="form-label">Brand</label>--%>
<%--    <input type="text" name="brand" class="form-control" id="brand">--%>
<%--    <div id="nameHelp" class="form-text">Enter brand</div>--%>
<%--  </div>--%>
<%--  <div class="mb-3">--%>
<%--    <label for="model" class="form-label">Model</label>--%>
<%--    <input type="text" name="model" class="form-control" id="model" aria-describedby="nameHelp">--%>
<%--    <div id="nameHelp" class="form-text">Enter model</div>--%>
<%--  </div>--%>
<%--  <div class="mb-3">--%>
<%--    <label for="color" class="form-label">Color</label>--%>
<%--    <input type="text" name="color" class="form-control" id="color" aria-describedby="nameHelp">--%>
<%--    <div id="nameHelp" class="form-text">Enter color</div>--%>
<%--  </div>--%>
<%--  <div class="mb-3">--%>
<%--    <label for="price" class="form-label">Price</label>--%>
<%--    <input type="number" name="price" class="form-control" id="price" aria-describedby="nameHelp">--%>
<%--    <div id="nameHelp" class="form-text">Enter price</div>--%>
<%--  </div>--%>
<%--  <div class="form-check">--%>
<%--    <input class="form-check-input" type="radio" name="isAvailable" value="true" id="flexRadioDefault1"/>--%>
<%--    <label class="form-check-label" for="flexRadioDefault1">Available</label>--%>
<%--  </div>--%>
<%--  <div class="form-check">--%>
<%--    <input class="form-check-input" type="radio" name="isAvailable" value="false" id="flexRadioDefault2" checked/>--%>
<%--    <label class="form-check-label" for="flexRadioDefault2">Not available</label>--%>
<%--  </div>--%>
<%--  <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--</form>--%>