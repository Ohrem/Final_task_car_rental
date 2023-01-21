<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internal car error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <div class="col-md-6 mx-auto">
        <main class="main">
            <div class="card bg-light mb-3" style="max-width: 30rem; margin: 10px 0 0">
                <div class="card-body">
                    <h2 class="card-text">Balance Error!</h2>
                    <hr style="width: 100%; color: #ff3b3b">
                    <h3 class="card-text">Balance number shouldn't be zero or null!</h3>
                    <hr style="width: 100%; color: #ff5151">
                    <form method="get" action="index.html">
                        <input type="submit" value="Try again" class="btn btn-danger btn-lg" style="width: 50%"/>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>

