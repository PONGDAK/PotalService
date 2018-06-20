<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-20
  Time: 오후 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <html>
    <head>
        <title>Title</title>
        <%@include file="../include/header.jsp" %>
    </head>
<body>
<%@include file="../include/admin_menu.jsp" %>
<div class="container">
    <div class="content">
        <h2>회원목록</h2>
        <input type="button" value="회원등록"
               onclick="location.href='${path}/management/write.do'">
        <table border="1" width="700px">
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>가입일자</th>
                <th>탈퇴예정</th>
            </tr>
            <c:forEach var="row" items="${list}">
                <tr>
                    <td>${row.userid}</td>
                    <td>
                        <a href="${path}/management/view.do?id=${row.id}">
                                ${row.name}</a>
                    </td>
                    <td>${row.email}</td>
                    <td><fmt:formatDate value="${row.join_date}"
                                        pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${row.cancel}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
