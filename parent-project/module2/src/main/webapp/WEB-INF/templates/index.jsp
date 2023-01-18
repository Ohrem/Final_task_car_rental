<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport">
    <title>index</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="wrapper">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>

    <main class="main">

        <div class="container" style="margin-top: -80px; margin-bottom: 30px">
            <div class="h1 indent-b-48 text-center">
                <p style="color: #002836; font-family: 'French Script MT';font-size: 60px; font-weight: normal">Hello
                    index</p>

            </div>
            <div class="benefits-secondary_wrapper" style="margin-top: 30px">
                <div class="benefits-secondary_item"
                     style="background-color: #f5f5f7; width:1298px;  border-radius: 5px; min-height: 292px; overflow: hidden; padding: 20px 40px 20px; position: relative; display: block;">
                    <img src="https://profiles.sulekha.com/mstore/40410510/albums/default/thumbnailfull/untitled-design.jpg"
                         class="benefits-secondary_image" alt="boll"
                         style="bottom: 0; display: block; height: 100%;max-height: 100%;object-position: left bottom;position: absolute; right: 0; width: auto; z-index: 0;">
                    <div class="benefits-secondary_content" style="min-width: 256px; position: relative; z-index: 1;">
                        <div class="benefits-secondary__title" style="font-size: 26px; line-height: 34px;">
                            <span class="colortext" style="color: #0d3d19">#Special Offers</span>
                        </div>
                        <div class="benefits-secondary_text"
                             style="margin-top: 8px; font-size: 16px; line-height: 24px; margin-right: 30px; width: 600px; ">
                            See our latest car leasing deals below.
                            Please be aware that these special offers may only be around for a limited amount of time.
                            Most of these car lease deals are available from stock and are therefore eligible for quick
                            delivery, usually 2-4 weeks.
                        </div>

                        <div class="benefits-secondary_title2"
                             style="font-size: 26px; line-height: 34px; margin-top: 30px">
                            <span class="colortext" style="color: #0d3d19">#Search for your dream</span>
                        </div>
                        <div class="benefits-secondary_text"
                             style="margin-top: 8px; font-size: 16px; line-height: 24px; width: 600px">
                            sorting TODO
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top: 30px; margin-bottom: 50px">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card">
                            <img src="https://www.rentacarkerala.in/wp-content/uploads/2018/10/best.jpg"
                                 class="card-img-top"
                                 alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Show cars</h5>
                                <p class="card-text"> Here you can see information about available cars. Pagination,
                                    in-page search and filtering implemented.</p>
                                <div class="d-grid gap-2 d-md-block">
                                    <a href="/hello/car-list.html" class="btn btn-primary">Click here</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <img src="https://www.talk-business.co.uk/wp-content/uploads/2017/04/car-leasing.jpg"
                                 class="card-img-top"
                                 alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Rent a car</h5>
                                <p class="card-text">By clicking on the link, register a car after going through 3 easy
                                    operations.</p>
                                </br>
                                <div class="d-grid gap-2 d-md-block">
                                    <a href="/hello/createOrder.html" class="btn btn-primary">Go rent a car</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/resources/imgs/3_index.webp"
                                 class="card-img-top"
                                 alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Order status</h5>
                                <p class="card-text">View information about the rental application, car,remaining
                                    amount, remaining time.</p>
                                <div class="d-grid gap-2 d-md-block">
                                    <a href="/hello/userResultInfo.html" class="btn btn-primary">Check Result</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table style="  width:100%" class="table">
            <tr>
                <th>Available Cars</th>
            </tr>
            <tr style="font-family: Serif; font-weight: bold">
                <td><p>Brand</p></td>
                <td><p>Model</p></td>
                <td><p>Color</p></td>
                <td><p>Color</p></td>
                <td><p>About car</p></td>
                <td><p>Click for rent</p></td>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td><c:out value="${car.brand}"/></td>
                    <td><c:out value="${car.model}"/></td>
                    <td><c:out value="${car.color}"/></td>
                    <td><c:out value="${car.price}"/></td>
                    <td><a href="${car.id}/viewCar.html" class="btn btn-light btn-sm active" role="button"
                           aria-pressed="true">About the car</a></td>
                    <td><a href="createOrder.html" class="btn btn-primary btn-sm active" role="button"
                           aria-pressed="true">Rent car</a></td>
                </tr>
            </c:forEach>
        </table>
        <footer>
            <jsp:include page="_footer.jsp"/>
        </footer>
    </main>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>
