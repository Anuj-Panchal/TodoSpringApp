<html lang="en">

<head>
  <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <title>
    Login Page
  </title>
</head>

<body>
  <div class="container">
    <h1>
      Login
    </h1>
    <hr/>
    <form action="/verify" method="post">
      <div class="form-group">
        <label for="userName">UserName</label>
        <input type="text" class="form-control" id="userName" placeholder="Enter UserName" name="user_name">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password">
      </div>
      <button type="submit" class="btn btn-success">Submit</button>
    </form>
  </div>

  <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>