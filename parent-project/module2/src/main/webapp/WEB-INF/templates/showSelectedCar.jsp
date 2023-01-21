<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Show selected car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <div class="container">
        <div class="col-md-6 mx-auto">
            <main class="main">
                <div class="card bg-light mb-3" style="max-width: 60rem; margin: 10px 0 0">
                    <div class="card-body">
                        <h3 class="card-title">Information about the selected car</h3>
                        <hr style="width: 100%; color: #00133a">
                        <h5 class="card-text">Brand: ${brand}</h5>
                        <hr style="width: 100%; color: #00133a">
                        <h5 class="card-text">Model: ${model}</h5>
                        <hr style="width: 100%; color: #00133a">
                        <h5 class="card-text">Color: ${color}</h5>
                        <hr style="width: 100%; color: #00133a">
                        <h5 class="card-text">Price: ${price}</h5>
                        <hr style="width: 100%; color: #00133a">
                        <h5 class="card-text">Description:</h5>
                        <h6 class="card-text">${description}</h6>
                        <hr style="width: 100%; color: #00133a">
                        <p class="card-text">
                            <image src="/hello/image/${carId}/carPhoto.jpg" class="img-car"
                                   style="width: 300px; height: 180px"></image>
                        </p>
                        <hr style="width: 100%; color: #494533">
                        <security:authorize access="hasRole('ADMIN')">
                            <p class="card-text">
                            <form action="/hello/${carId}/createOrderSelectedCar.html" method="get">
                                <input type="submit" value="Rent a car" class="btn btn-primary btn-sm active" style="width: 100%"/>
                            </form>
                            </p>
                        </security:authorize>
                        <security:authorize access="hasRole('USER')">
                            <p class="card-text">
                            <form action="/hello/${carId}/createOrderSelectedCar.html" method="get">
                                <input type="submit" value="Rent a car" class="btn btn-primary btn-sm active" style="width: 100%"/>
                            </form>
                            </p>
                        </security:authorize>
                        <hr style="width: 100%; color: #494533">
                        <p class="card-text">
                        <form action="/hello/index.html" method="get">
                            <input type="submit" value="Back to main" class="btn btn-success btn-sm" style="width: 100%"/>
                        </form>
                        </p>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>
</body>
</html>
