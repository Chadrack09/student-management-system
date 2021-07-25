<main class="container log-container">
  <div class="row">
    <div class="col-sm-12 col-lg-6 form-column">
      <h1 class="text-center">Log in</h1>
      <small class="text-center">Please enter both details username and password</small>
      <small class="text-center">Username: <span class="text-danger">chadrack</span> Password: <span class="text-danger">123</span></small>
      
      <form action="Login" method="POST">
        <div class="form-group">
          <input type="text" placeholder="Username" class="form-control mb-1" name="username">
          <input type="password" class="form-control mb-2" name="password" placeholder="Password">
        </div>
        <div class="form-button">
          <div class="btn-submit">
            <input type="submit" value="Log In" class="btn btn-primary w-100 mb-1">
          </div>
        </div>
      </form>          
    </div>
    <div class="col img-column">
      <img src="img/student_img1.jpg" alt="Student Graduate" srcset="" class="img-thumbnail rounded">
    </div>
  </div>
</main>
