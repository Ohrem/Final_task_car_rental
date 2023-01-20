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
      <main class="main">
        <div class="card bg-light mb-3" style="max-width: 30rem; margin: 20px 0 0">
          <div class="card-body">
            <h3 class="card-title">Resume</h3>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text">Rent price: ${paymentSum}</h5>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text">Is order paid for: ${isPaid}</h5>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text">Remaining days: ${remainingDays}</h5>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text">Rest of payment: ${restPayment}</h5>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text" style="color: red">${comment}</h5>
            <p class="card-text">
            <form action="processPayment.html">
              <input type="submit" value="To pay" class="btn btn-primary"/>
            </form>
            </p>
            <hr style="width: 100%; color: #494533">
            <h5 class="card-text">User balance: ${userBalance}</h5>
            <p class="card-text">
            <form action="addBalance.html">
              <input type="submit" value="Add money" class="btn btn-danger"/>
            </form>
            <hr style="width: 100%; color: moccasin">
            <h5 class="card-text">Car information:</h5>
            <h6 class="card-text">Brand: ${orderCar.brand}, Model: ${orderCar.model}, Color: ${orderCar.color}, Price: ${orderCar.price}</h6>
            <hr>
            <form action="cancelOrder.html">
              <input type="submit" value="Cancel order" class="btn btn-dark" style="width: 30%"/>
            </form>
            <hr>
            <form action="index.html">
              <input type="submit" value="Home" class="btn btn-success btn-sm" style="width: 100%"/>
            </form>
          </div>
        </div>
      </main>
    </div>
  </div>
</div>
</body>
</html>
