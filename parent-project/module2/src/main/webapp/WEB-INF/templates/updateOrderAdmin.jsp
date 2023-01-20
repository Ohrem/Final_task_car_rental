<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <jsp:include page="_header.jsp"/>
</header>

<div class="container" style="margin-top: 10px">
    <div class="col-md-6 mx-auto">
        <div class="row" style="margin: 10px 0 0">
            <h4 style="padding: 0;">
                Update User
            </h4>
        </div>
        <div class="row" style="margin-top: 10px">
            <form class="row g-3" method="post" action="/hello/updateOrderAdmin.html">
                <div class="col-5">
                    <label for="inputBeginDate" class="form-label">Begin date</label>
                    <input name="beginDate" type="date" class="form-control" id="inputBeginDate" placeholder="22.07.2023" require>
                </div>
                <div class="col-5">
                    <label for="inputEndDate" class="form-label">End date</label>
                    <input name="endDate" type="date" class="form-control" id="inputEndDate" placeholder="25.10.2023">
                </div>
                <div class="col-2">
                    <input type="hidden" name="orderId" value="${orderId}">
                </div>
                <div class="col-12">
                    <label for="inputMessage" class="form-label">Message</label>
                    <input name="message" type="text" class="form-control" id="inputMessage" placeholder="Message"
                           pattern="^([A-Za-z]{1,40})$" required>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary active" style="width: 100%">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%--<form method="post" action="/hello/updateOrderAdmin.html">--%>
<%--    <input type="hidden" name="orderId" value="${orderId}">--%>
<%--    <input type="date" name="beginDate">--%>
<%--    <input type="date" name="endDate">--%>
<%--    <input type="text" name="message">--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>

</body>
</html>
