<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateOrder</title>
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
            <div class="row" style="margin: 20px 0 0">
                <h1 style="padding: 0">
                    Filling in the date
                </h1>
            </div>
            <main class="main">
                <div class="card bg-light mb-3" style="max-width: 30rem; margin: 20px 0 0">
                    <div class="card-body">
                        <h6 class="card-title">Rental procedure</h6>
                        <p class="card-text">To continue rent, please, fill in the payment date.</p>
                    </div>
                </div>
                <div class="row" style="margin-top: -10px">
                    <form class="row g-3 " action="/hello/paymentEntity.html" method="post" id="payment_form">
                        <div class="col-10">
                            <label for="inputPaymentDate" class="form-label">Payment date</label>
                            <input name="paymentDate" type="date" class="form-control" id="inputPaymentDate" required>
                        </div>
                        <div class="col-2"></div>
                        <div class="col-10">
                            <button class="btn btn-success btn-sm" type="submit" style="width: 100%">Next</button>
                        </div>
                    </form>
                </div>
            </main>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>
