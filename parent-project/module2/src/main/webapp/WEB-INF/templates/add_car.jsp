<header>
    <jsp:include page="_header.jsp"/>
</header>
<form method="post" action="/hello/add-car.html" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="photo" class="form-label">Photo</label>
        <input type="file" name="photo" class="form-control" id="photo">
    </div>
    <div class="mb-3">
        <label for="brand" class="form-label">Brand</label>
        <input type="text" name="brand" class="form-control" id="brand">
        <div id="nameHelp" class="form-text">Enter brand</div>
    </div>
    <div class="mb-3">
        <label for="model" class="form-label">Model</label>
        <input type="text" name="model" class="form-control" id="model" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter model</div>
    </div>
    <div class="mb-3">
        <label for="color" class="form-label">Color</label>
        <input type="text" name="color" class="form-control" id="color" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter color</div>
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="number" name="price" class="form-control" id="price" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter price</div>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="isAvailable" value="true" id="flexRadioDefault1"/>
        <label class="form-check-label" for="flexRadioDefault1">Available</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="isAvailable" value="false" id="flexRadioDefault2" checked/>
        <label class="form-check-label" for="flexRadioDefault2">Not available</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
