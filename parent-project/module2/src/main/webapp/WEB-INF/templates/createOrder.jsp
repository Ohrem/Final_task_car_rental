<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CreateOrder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
        <div class="container mt-5">
            <div class="row">
                <form class="col s12" method="post" action="/hello/createOrder.html">
                    <div class="row">
                        <div class="inputs">
                            <div class="input-field col s6">
                                <input type="date" id="begin-date" name="beginDate" class="validate">
                                <label for="begin-date">Begin date</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="end-date" type="date" name="endDate" class="validate">
                                <label for="end-date">End date</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="user-message" type="text" name="message" class="validate">
                                <label for="user-message">Message</label>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="car_id" type="number" name="carId" class="validate">
                                    <label for="car_id">Car id</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex mt-4 justify-content-between">
                        <button class="write btn" type="submit">Next</button>
                    </div>
                </form>
<%--                <div class="row">--%>
<%--                    <div class="form-select form-select-lg mb-3">--%>
<%--                        <select name="carId">--%>
<%--                            <option value="-1">Select a car</option>--%>
<%--                            <c:forEach items="${allCars}" var="car">--%>
<%--                                <c:out value="${car.id}"/>--%>
<%--                                <option value="${car.id}"></option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer.jsp"/>
    </footer>
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</html>
