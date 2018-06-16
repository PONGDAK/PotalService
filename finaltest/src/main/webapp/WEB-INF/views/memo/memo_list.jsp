<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-16
  Time: 오전 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메모장</title>
    <%@include file="../include/header.jsp" %>

    <!-- include libraries(bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js -->
    <link href="${path}/summernote/summernote.css" rel="stylesheet">
    <script src="${path}/summernote/summernote.js"></script>

    <script>
        $(function() {
            //id가 memo인 태그를 summernote로 변경
            $("#memo").summernote({
                height : 150,
                width : 600
            });
        });

        function memo_view(id) {
            location.href = "${path}/memo/view/" + id;
        }
    </script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>메모장</h2>
<form method="post" action="${path}/memo/insert.do">
    이름 : <input name="writer" size="10"><br>
    메모 : <!-- <input id="memo" name="memo" size="40"> -->
    <textarea rows="3" cols="50" name="memo" id="memo"></textarea>
    <input type="submit" value="확인">
</form>
<table border="1" width="500px">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>메모</th>
        <th>날짜</th>
    </tr>
    <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.id}</td>
            <td>${row.writer}</td>
            <td><a href="#" onclick="memo_view('${row.id}')">
                    ${row.memo}</a></td>
            <td><fmt:formatDate value="${row.post_date}"
                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
