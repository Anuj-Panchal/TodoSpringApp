<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="">
<head>
  <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  <title>
    Add Todo
  </title>
</head>
<body>
  <div class="container">
    <%@ include file="common/navigation.jspf" %>

    <h1>Add Todo</h1>
    <hr/>

    <form:form method="post" modelAttribute="todo">
      <div class="form-group">
        <label for="description">Description</label>
        <form:input type="text" class="form-control" id="description" placeholder="Enter Description" name="description" path="description"/>
        <form:errors path="description" cssClass="text-warning"/>
      </div>
      <div class="form-group">
        <label for="targetDate">Target Date</label>
        <form:input type="date" class="form-control" id="targetDate" placeholder="Enter targetDate" name="targetDate" path="targetDate"/>
        <form:errors path="targetDate" cssClass="text-warning"/>
      </div>
      <div class="form-check">
        <form:checkbox class="form-check-input" id="isDone" name="isDone" path="isDone"/>
        <label class="form-check-label" for="isDone">Completed</label>
      </div>
      <form:button type="submit" class="btn btn-success">Submit</form:button>
    </form:form>
  </div>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>