<html lang="en">

<head>
  <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <title>
    Welcome Page
  </title>
</head>

<body>
  <div class="container">
    <%@ include file="common/navigation.jspf" %>
    <p>
      Welcome ${name}, Login Successful!
    </p>
    <a href="todo/show">
      Manage Todos
    </a>
  </div>

  <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>