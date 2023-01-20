<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security handler</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">
    <div class="col-md-6 mx-auto">
        <main class="main">
            <div class="card bg-light mb-3" style="max-width: 30rem; margin: 10px 0 0">
                <div class="card-body">
                    <h2 class="card-text">Payment error!</h2>
                    <hr style="width: 100%; color: #ff3b3b">
                    <h3 class="card-text">Тебя здесь быть не должно!</h3>
                    <hr style="width: 100%; color: #ff5151">
                    <form action="index.html">
                        <input type="submit" value="Home" class="btn btn-danger btn-lg" style="width: 30%"/>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
