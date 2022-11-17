<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 17.11.2022
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet311</title>
</head>
<body>
<p>Hello in your language</p>
<div><c:out value="${welcome}" default = "Choose your favourite language"/></div>
    <form action="/servlet312" method="POST">
        <select name="language">
            <option value="en">English</option>
            <option value="pl">Polish</option>
            <option value="de">German</option>
            <option value="es">Spanish</option>
            <option value="fr">French</option>
        </select>
        <button type="submit">Send</button>
    </form>

</body>
</html>
