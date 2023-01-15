<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>

    <main class="main"><h1>Home page</h1>
        <img src="${pageContext.request.contextPath}/resources/imgs/car_on_forest_road_4k_hd_nature.jpg" class="img-fluid" alt="" width="100%">
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" style="width: 280px; height: 200px;"
                 src="https://www.talk-business.co.uk/wp-content/uploads/2017/04/car-leasing.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
                <a href="/hello/createOrder.html" class="btn btn-primary">Go rent a car</a>
            </div>
        </div>

        <div class="card" style="width: 18rem;">
            <img class="card-img-top" style="width: 280px; height: 200px;"
                 src="https://millionmilesecrets.com/wp-content/uploads/shutterstock_394789348.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">Order result info</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
                <a href="/hello/userResultInfo.html" class="btn btn-primary">check Result</a>
            </div>
        </div>


        <table style="width:100%" class="table">
            <tr>
                <th>Cars</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td><c:out value="${car.brand}"/></td>
                    <td><c:out value="${car.model}"/></td>
                    <td><c:out value="${car.color}"/></td>
                    <td><c:out value="${car.price}"/></td>
                </tr>
            </c:forEach>
        </table>
        <footer>
            <jsp:include page="_footer.jsp"/>
        </footer>
    </main>
</div>
</body>
</html>
