<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <main class="main"><h1>Home page</h1></main>
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://www.talk-business.co.uk/wp-content/uploads/2017/04/car-leasing.jpg"
             alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                card's content.</p>
            <a href="/hello/createOrder.html" class="btn btn-primary">Go rent a car</a>
        </div>
    </div>

    <table style="width:100%" class="table">
        <tr>
            <th>Name</th>
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

    <select name="select">
        <option value="-1">Select a car</option>
        <c:forEach items="${allCars}" var="car">
            <option value="${car.id}">${car.brand}, ${car.model}, ${car.color}, ${car.price}</option>
        </c:forEach>
    </select>

    <select name="select2"> <!--Supplement an id here instead of using 'name'-->
        <option value="value1">Значение 1</option>
        <option value="value2" selected>Значение 2</option>
        <option value="value3">Значение 3</option>
    </select>

    <footer>
        <jsp:include page="_footer.jsp"/>
    </footer>
</div>
</body>
</html>
