<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CreateOrder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <main class="main">
        <div class="card" style="width: 35rem; margin-left: 170px; margin-top: 15px;">
            <div class="card-content">
                <p>Happy to welcome! To fill the form, you need to go through 3 taps</p>
            </div>
        </div>
        <div class="container-form">
            <form method="post" action="/hello/createOrder.html">
                <div class="input-group mb-3">
                    <input type="date" id="begin-date" name="beginDate" class="validate">
                    <label for="begin-date">Begin date</label>
                </div>

                <div class="input-group mb-3">
                    <input id="end-date" type="date" name="endDate" class="validate">
                    <label for="end-date">End date</label>
                </div>
                <div class="input-group mb-3">
                    <input id="user-message" type="text" name="message" class="validate">
                    <label for="user-message">Message</label>
                </div>
                <div class="input-group mb-3">
                    <select name="carId">
                        <option value="-1">Select a car</option>
                        <c:forEach items="${allCars}" var="car">
                            <option value="${car.id}">${car.brand}, ${car.model}, ${car.color}, ${car.price}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class=<div class="input-group mb-3">
                    <button type="submit" class="btn btn-secondary">Next</button>
                </div>
            </form>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer_util.jsp"/>
    </footer>
</div>
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>--%>
</html>
