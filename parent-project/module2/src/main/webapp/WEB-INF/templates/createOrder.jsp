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
    <div class="container">
        <div class="col-md-6 mx-auto">
            <div class="row" style="margin: 20px 0 0">
                <h1 style="padding: 0">
                    Rent your car
                </h1>
            </div>
            <main class="main">
                <div class="card bg-light mb-3" style="max-width: 30rem; margin: 20px 0 0">
                    <div class="card-body">
                        <h5 class="card-title">Start of the rental procedure</h5>
                        <p class="card-text">Happy to welcome! To rent a car, please, fill in the form.</p>
                    </div>
                </div>

                <div class="row" style="margin-top: -10px">
                    <form class="row g-3 " action="/hello/createOrder.html" method="post" id="order_form">
                        <div class="col-6">
                            <label for="inputBeginDate" class="form-label">Begin date</label>
                            <input name="beginDate" type="date" class="form-control" id="inputBeginDate" required>
                        </div>
                        <div class="col-6">
                            <label for="inputEndDate" class="form-label">End date</label>
                            <input name="endDate" type="date" class="form-control" id="inputEndDate" required>
                        </div>
                        <div class="col-4">
                            <label for="selectSec" class="form-label">Select car</label>
                            <select class="form-control" id="selectSec" name="carId">
                                <c:forEach items="${cars}" var="car">
                                    <option value="${car.id}">${car.brand}, ${car.model}, ${car.color}, ${car.price}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-8">
                            <label for="inputMessage" class="form-label">Message</label>
                            <input name="message" type="text" class="form-control" id="inputMessage" required>
                        </div>
                        <div class="col-4"></div>
                        <div class="col-6">
                            <button type="submit" class="btn btn-success" style="width: 100%">Continue</button>
                        </div>
                    </form>
                    <div class="col-2" style="margin-left: 548px; margin-top: -53px">
                        <form action="index.html">
                            <input type="submit" value="Home" class="btn btn-primary" style="width: 100%"/>
                        </form>
                    </div>
                </div>
            </main>


            <%--        <div class="container-form">--%>
            <%--            <form method="post" action="/hello/createOrder.html">--%>
            <%--                <div class="form-row">--%>
            <%--                    <div class="row">--%>
            <%--                        <div class="col-sm-5">--%>
            <%--                            <input type="date" id="begin-date" name="beginDate" class="form-control">--%>
            <%--                            <label for="begin-date">Begin date</label>--%>
            <%--                        </div>--%>
            <%--                        <div class="col-sm-5">--%>
            <%--                            <input id="end-date" type="date" name="endDate" class="form-control">--%>
            <%--                            <label for="end-date">End date</label>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div class="row">--%>
            <%--                        <div class="col sm-5">--%>
            <%--                            <select class="form-control" id="exampleFormControlSelect1" name="carId">--%>
            <%--                                <c:forEach items="${cars}" var="car">--%>
            <%--                                    <option value="${car.id}">${car.brand}, ${car.model}, ${car.color}, ${car.price}</option>--%>
            <%--                                </c:forEach>--%>
            <%--                            </select>--%>
            <%--                        </div>--%>
            <%--                        <div class="col sm-5">--%>
            <%--                            <input id="user-message" type="text" name="message" class="form-control">--%>
            <%--                            <label for="user-message">Message</label>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div class=<div class="input-group mb-3">--%>
            <%--                        <button type="submit" class="btn btn-primary">Continue</button>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </form>--%>
            <%--        </div>--%>

        </div>
    </div>
    <%--    <footer>--%>
    <%--        <jsp:include page="_footer_util.jsp"/>--%>
    <%--    </footer>--%>
</div>
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</html>
