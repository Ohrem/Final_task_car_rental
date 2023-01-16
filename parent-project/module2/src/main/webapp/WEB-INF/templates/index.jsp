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

        <div class="card-container">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" style="width: 280px; height: 200px; margin-left: 4px;margin-top: 4px"
                     src="https://www.rentacarkerala.in/wp-content/uploads/2018/10/best.jpg"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Show cars</h5>
                    <p class="card-text">Here you can see information about available cars. Pagination, in-page search and filtering implemented. </p>
                    <a href="/hello/list-cars.html" class="btn btn-primary">check cars</a>
                </div>
            </div>
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" style="width: 280px; height: 200px; margin-left: 4px; margin-top: 4px"
                     src="https://www.talk-business.co.uk/wp-content/uploads/2017/04/car-leasing.jpg"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Rent a car</h5>
                    <p class="card-text">By clicking on the link, register a car after going through 3 easy operations.</p>
                    <a href="/hello/createOrder.html" class="btn btn-primary">Go rent a car</a>
                </div>
            </div>

            <div class="card" style="width: 18rem;">
                <img class="card-img-top" style="width: 280px; height: 200px; margin-left: 4px;margin-top: 4px"
                     src="https://millionmilesecrets.com/wp-content/uploads/shutterstock_394789348.jpg"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Order result info</h5>
                    <p class="card-text">View information about the rental application, car,remaining amount, remaining time.</p>
                    <a href="/hello/userResultInfo.html" class="btn btn-primary">check Result</a>
                </div>
            </div>
        </div>

        <table style="width:100%" class="table">
            <tr>
                <th>Available Cars</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td><c:out value="${car.brand}"/></td>
                    <td><c:out value="${car.model}"/></td>
                    <td><c:out value="${car.color}"/></td>
                    <td><c:out value="${car.price}"/></td>
                    <td><a href="#" class="btn btn-light btn-sm active" role="button" aria-pressed="true">About the car</a></td>
                    <td><a href="createOrder.html" class="btn btn-primary btn-sm active" role="button" aria-pressed="true">Rent car</a></td>

                <%--                    <td><button type="button" onclick="window.location.href = 'https://google.com';" class="btn btn-light btn-sm">About the car</button></td>--%>
<%--                    <td><button type="button" onclick="window.location.href = 'https://google.com';" class="btn btn-primary btn-sm">Rent a car</button></td>--%>

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
