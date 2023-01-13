<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateOrder</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <main class="main">
        <div class="card" style="width: 35rem; margin-left: 170px; margin-top: 15px;">
            <div class="card-content">
                <p>Please fill in the payment date</p>
            </div>
        </div>
        <div class="container mt-5">
            <div class="row">
                <form class="col s12" method="post" action="/hello/paymentEntity.html">
                    <div class="row">
                        <div class="inputs">
                            <div class="input-field col s6">
                                <input type="date" id="payment-date" name="paymentDate" class="validate">
                                <label for="payment-date">Payment date</label>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex mt-4 justify-content-between">
                        <button class="write btn" type="submit">Next</button>
                    </div>
                </form>
            </div>
        </div>
        <main/>
        <footer>
            <jsp:include page="_footer.jsp"/>
        </footer>
    </main>
</div>
</body>
</html>
