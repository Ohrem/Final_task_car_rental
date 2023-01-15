<form method="post" action="/hello/add-user.html" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="photo" class="form-label">Photo</label>
        <input type="file" name="photo" class="form-control" id="photo">
    </div>
    <!-- firstName -->
    <div class="mb-3">
        <label for="name" class="form-label">First Name</label>
        <input type="text" name="name" class="form-control" id="name" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter first name</div>
    </div>
    <!-- lastName -->
    <div class="mb-3">
        <label for="surname" class="form-label">Last Name</label>
        <input type="text" name="surname" class="form-control" id="surname" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter last name</div>
    </div>
    <!-- birthDate -->
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="text" name="email" class="form-control" id="email" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Enter Email</div>
    </div>
    <!-- employeeDetail.city -->
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="text"  name="password" class="form-control" id="password" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Password</div>
    </div>
    <!-- employeeDetail.street -->
    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" name="phone" class="form-control" id="phone" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Phone</div>
    </div>
    <div class="mb-3">
        <label for="role" class="form-label">Role</label>
        <input type="text" name="role" class="form-control" id="role" value="USER" readonly aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Role</div>
    </div>
    <div class="mb-3">
        <label for="balance" class="form-label">Balance</label>
        <input type="text" name="balance" class="form-control" id="balance" aria-describedby="nameHelp">
        <div id="nameHelp" class="form-text">Balance</div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
