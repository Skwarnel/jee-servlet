<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 17.11.2022
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My one and hundred one page</title>
</head>
<body>
  <c:forEach var="num" begin="2" end="10" step="2" items="${list}">
      <c:out value="${num}"/>
  </c:forEach>
</body>
</html>
