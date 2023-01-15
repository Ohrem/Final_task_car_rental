<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Footer_util</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<footer class="text-center text-white" style="background-color: #f1f1f1;">
    <!-- Grid container -->
    <div class="container pt-4">
        <!-- Section: Social media -->
        <section class="mb-4">
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
                <img src="${pageContext.request.contextPath}/resources/imgs/Facebook_Logo_(2019).png"
                     alt="https://www.facebook.com/" width="25" height="25"/>
                <i class="fab fa-instagram-f"></i></a>
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
                <img src="${pageContext.request.contextPath}/resources/imgs/twitter-logo-vector-png-clipart-1.png"
                     alt="https://twitter.com/" width="25" height="25"/>
                <i class="fab fa-twitter"></i></a>

            <!-- Google -->
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
                <img src="${pageContext.request.contextPath}/resources/imgs/Gmail_Logo_512px.png"
                     alt="" width="25" height="25"/>
                <i class="fab fa-google"></i></a>

            <!-- Instagram -->
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
                <img src="${pageContext.request.contextPath}/resources/imgs/640px-Instagram_icon.png"
                     alt="" width="25" height="25"/>
                <i class="fab fa-instagram-f"></i></a>
            <i class="fab fa-instagram"></i></a>

            <!-- Linkedin -->
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
            <img src="${pageContext.request.contextPath}/resources/imgs/linkedIn.png"
                 alt="" width="25" height="25"/>
            <i class="fab fa-linkedin"></i></a>
            <!-- Github -->
            <a class="btn btn-link btn-floating btn-lg text-dark m-1">
            <img src="${pageContext.request.contextPath}/resources/imgs/gitHub.png"
                 alt="https://github.com/Ohrem" width="25" height="25"/>
            <i class="fab fa-instagram-f"></i></a>
            <i class="fab fa-github"></i
            ></a>
        </section>
        <!-- Section: Social media -->
    </div>
    <div class="text-center text-dark p-3" style="background-color: #d9d9d9" ;>
        © 2023 Copyright:
        <a class="text-dark" href="/hello/index.html">Car Rental</a>
    </div>
    <!-- Copyright -->
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
