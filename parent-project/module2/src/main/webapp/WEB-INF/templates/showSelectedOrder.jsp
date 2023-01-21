<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show selected order </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <div class="container">
        <div class="col-md-6 mx-auto">
            <main class="main">
                <div class="card bg-light mb-3" style="max-width: 50rem; margin: 10px 0 0">
                    <div class="card-body">
                        <h3 class="card-title">Order</h3>
                        <hr style="width: 100%; color: #494533">
                        <h5 class="card-text">Begin date: ${beginDate}</h5>
                        <hr style="width: 100%; color: #494533">
                        <h5 class="card-text">End date: ${endDate}</h5>
                        <hr style="width: 100%; color: #494533">
                        <h5 class="card-text">Message: ${message}</h5>
                        <hr style="width: 100%; color: #494533">
                        <form action="/hello/index.html" method="get">
                            <input type="submit" value="Back to main" class="btn btn-success btn-sm" style="width: 100%"/>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>
</body>
</html>
