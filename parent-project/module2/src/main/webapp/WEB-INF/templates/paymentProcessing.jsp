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
                    Filling the sum amount
                </h1>
            </div>
            <main class="main">
                <div class="card bg-light mb-3" style="max-width: 30rem; margin: 20px 0 0">
                    <div class="card-body">
                        <p class="card-title">Please fill in the payment sum</p>
                        <hr style="width: 100%; color: moccasin">
                        <h6 class="card-text">Balance:</h6>
                        <h5 class="card-text">User balance is: ${userBalance}</h5>
                        <hr style="width: 100%; color: moccasin">
                        <h6 class="card-text">Left to pay:</h6>
                        <h3 class="card-text">Payment sum is: ${paymentSum}</h3>
                        <hr style="width: 100%; color: #ffc7cb">
                        <p class="card-text">
                            <a href="addBalance.html" class="btn btn-danger btn-sm active" role="button"
                                                aria-pressed="true">Add balance</a>
                        </p>
                    </div>
                </div>
                <div class="row" style="margin-top: -10px">
                    <form class="row g-3 " action="/hello/processPayment.html" method="post" id="processPayment_form">
                        <div class="col-9">
                            <label for="inputPaymentSum" class="form-label">Payment sum</label>
                            <input name="checkoutPayment" type="number" class="form-control" id="inputPaymentSum"
                                   required>
                        </div>
                        <div class="col-3"></div>
                        <div class="col-6">
                            <button class="btn btn-success btn-sm" type="submit" style="width: 100%">Next</button>
                        </div>
                    </form>
                    <div class="col-3" style="margin-left: 328px; margin-top: -47px">
                        <form action="hello/index.html" method="get">
                            <button type="button" class="btn btn-primary btn-sm" style="width: 100%">Back to main
                            </button>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>

</main>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>