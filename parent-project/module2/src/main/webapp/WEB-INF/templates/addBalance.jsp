<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add balance</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<c:import url="_header.jsp"/>
<div class="container" style="margin-top: 30px">
    <div class="col-md-8 mx-auto">
        <div class="row" style="margin: 10px 0 0">
            <h1 style="padding: 0;">
                Add balance
            </h1>
        </div>
        <div class="row" style="margin-top: 10px">
            <form class="row g-3" action="/hello/addBalance.html" method="post">
                <div class="col-6">
                    <label for="inputBalance" class="form-label">Add money ($)</label>
                    <input name="addBalanceSum" type="number" class="form-control" id="inputBalance" pattern="[0-9]{,3}" placeholder="70.56"
                           required accept="image/*">
                </div>
                <div class="col-6"></div>
                <div class="col-6">
                    <button type="submit" class="btn btn-warning btn-lg" style="width: 50%">Add money</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
