<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-09
  Time: 오후 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/menu.jsp" %>

<c:if test="${sessionScope.userid != null }">
    <h2>
            ${sessionScope.name}
        (${sessionScope.userid})님의 방문을 환영합니다.
    </h2>
</c:if>

<h1>Hello world!</h1>

<P>The time on the server is ${serverTime}.</P>
</body>
</html>
