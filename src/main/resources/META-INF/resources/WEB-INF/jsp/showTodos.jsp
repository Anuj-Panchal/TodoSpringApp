<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="">
<head>
  <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <title>
    Show Todos
  </title>
</head>
<body>
  <div class="container">
    <%@ include file="common/navigation.jspf" %>

    <h1>Welcome ${name}</h1>
    <hr/>
    <p>
      Your Todo List:
    </p>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Completed?</th>
          <th>Update</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todos">
          <tr>
            <td>${todos.getId()}</td>
            <td>${todos.getDescription()}</td>
            <td>${todos.getTargetDate()}</td>
            <td>${todos.getIsDone()}</td>
            <td>
              <form action="delete-todo" method="post">
                <input type="hidden" name="id" value=${todos.getId()} />
                <button type="submit" class="btn btn-warning">Delete</button>
              </form>
            </td>
            <td>
              <form action="update-todo" method="get">
                <input type="hidden" name="id" value=${todos.getId()} />
                <button type="submit" class="btn btn-primary">Update</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
  </div>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>