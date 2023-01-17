<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
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
                Add user
            </h1>
        </div>
        <div class="row" style="margin-top: 10px">
            <form class="row g-3" action="/hello/add-user.html" method="post" onsubmit="return confirm('Уверены?')" enctype="multipart/form-data">
                <div class="col-6">
                    <label for="inputPhoto" class="form-label">User photo</label>
                    <input name="photo" type="file" class="form-control" id="inputPhoto" placeholder="photo.jpg"
                           required accept="image/*">
                </div>
                <div class="col-6">
                    <label for="inputName" class="form-label">Name</label>
                    <input name="name" type="text" class="form-control" id="inputName" placeholder="Alex" required
                           pattern="^([A-Za-z]{1,18})$">
                </div>
                <div class="col-6">
                    <label for="inputSurname" class="form-label">Surname</label>
                    <input name="surname" type="text" class="form-control" id="inputSurname" placeholder="Ivanov"
                           pattern="^([A-Za-z]{1,25})$" required>
                </div>
                <div class="col-6">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input name="email" type="text" class="form-control" id="inputEmail" placeholder="impress@mail.ru"
                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                </div>
                <div class="col-4">
                    <label for="inputPassword" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="inputPassword"
<%--                           pattern="^[a-zA-Z0-9].{4,}"--%>
                           title="Must contain at least one number and one uppercase and lowercase letter, and at least 4 or more characters"
                           required>
                </div>
                <div class="col-4">
                    <label for="inputPhone" class="form-label">Phone</label>
                    <input name="phone" type="tel" class="form-control" id="inputPhone" placeholder="+375447714281"
                           pattern="^(\+)?[0-9]{5,12}"
                           required>
                </div>
                <div class="col-4">
                    <label for="inputRole" class="form-label">Role</label>
                    <input name="role" type="text" class="form-control" id="inputRole" value="USER" readonly required>
                </div>
                <div class="col-4">
                    <label for="inputBalance" class="form-label">Balance</label>
                    <input name="balance" type="number" class="form-control" id="inputBalance" value="0" readonly
                           required>
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

