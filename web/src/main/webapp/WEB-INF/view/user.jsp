<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.01.2018
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User`s welcome</title>
</head>
<body>
<h1>userWelcom.jsp</h1>
<h2><%= request.getAttribute("userExampleWelcome") %></h2>
</br >
</br>
<a href="<c:url value = "/index.jsp"/>">index.jsp</a></br>
<a href="<c:url value = "/welcome"/>" style="pointer-events: none; cursor: default; color: #999;">user.jsp</a></br>
</body>
</html>
