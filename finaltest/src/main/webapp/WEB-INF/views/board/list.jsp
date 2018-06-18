<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-19
  Time: 오전 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시판</h2>
${map.count}개의 게시글이 있습니다.
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>날짜</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${map.list}">
        <tr>
            <td>${row.id}</td>
            <td>${row.title}</td>
            <td>${row.writer}</td>
            <td><fmt:formatDate value="${row.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${row.view_count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
