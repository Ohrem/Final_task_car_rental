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
        <div class="card bg-light mb-3" style="max-width: 30rem;">
            <div class="card-body">
                <h5 class="card-title">Start of the rental procedure</h5>
                <p class="card-text">Happy to welcome! To rent a car, please, fill in the form.</p>
            </div>
        </div>
        <div class="container-form">
            <form method="post" action="/hello/createOrder.html">
                <div class="form-row">
                    <div class="row">
                        <div class="col-sm-5">
                            <input type="date" id="begin-date" name="beginDate" class="form-control">
                            <label for="begin-date">Begin date</label>
                        </div>
                        <div class="col-sm-5">
                            <input id="end-date" type="date" name="endDate" class="form-control">
                            <label for="end-date">End date</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col sm-5">
                            <select class="form-control" id="exampleFormControlSelect1" name="carId">
                                <c:forEach items="${allCars}" var="car">
                                    <option value="${car.id}">${car.brand}, ${car.model}, ${car.color}, ${car.price}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col sm-5">
                            <input id="user-message" type="text" name="message" class="form-control">
                            <label for="user-message">Message</label>
                        </div>
                    </div>
                    <div class=<div class="input-group mb-3">
                        <button type="submit" class="btn btn-primary">Continue</button>
                    </div>
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
</html>
