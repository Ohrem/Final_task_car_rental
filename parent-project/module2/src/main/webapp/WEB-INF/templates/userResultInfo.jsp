<%--
  Created by IntelliJ IDEA.
  User: evgeniy.hozhaynov
  Date: 13.01.2023
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Payment sum: ${paymentSum}
    Rest of payment: ${restPayment}
    User balance: ${userBalance}
    Car: ${orderCar}
    Remaining days: ${remainingDays}
    Is order paid for: ${isPaid}
  <form action="addBalance.html">
    <input type="submit" value="Add money" />
  </form>
  <form action="cancelOrder.html">
    <input type="submit" value="Cancel order" />
  </form>
  <form action="processPayment.html">
    <input type="submit" value="Payment" />
  </form>
</body>
</html>
