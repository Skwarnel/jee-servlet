<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 17.11.2022
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Newsletter request</title>
</head>
<body>
  <h1>Whatever content</h1>

  <form action="/newsletter" method="POST">
    <label>
      <input type="text" name="name">
    </label>
    <label>
      <input type="text" name="email">
    </label>
    <button type="submit">Send</button>
  </form>
</body>
</html>
