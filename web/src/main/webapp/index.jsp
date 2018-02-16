<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Index.jsp</h1>
<h2>Hello World!</h2>
</br>
</br>
<a href="<c:url value = "/index.jsp"/>" style="pointer-events: none; cursor: default; color: #999;">index.jsp</a></br>
<a href="<c:url value = "/welcome"/>"> userWelcom.jsp</a></br>
<a href="<c:url value = "/lease"/>"> 3rd check point (filter, paging)</a></br>
</body>
</html>
