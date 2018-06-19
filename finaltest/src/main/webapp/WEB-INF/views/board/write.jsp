<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-19
  Time: 오후 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
    <%@include file="../include/header.jsp" %>
    <script>
        $(function () {
            $("#btnSave").click(function () {
                document.form1.submit();
            });
        });
    </script>
    <style>
        .fileDrop{
            width: 600px;
            height: 100px;
            border: 1px dotted gray;
            background-color: gray;
        }
    </style>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>글쓰기</h2>
<form id="form1" name="form1" method="post" action="${path}/board/insert.do">
    <div>
        제목 <input name="title" id="title" size="80" placeholder="제목을 입력하세요">
    </div>
    <div style="width:800px;">
        내용<textarea id="content" name="content" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
    </div>
    <div>첨부파일
        <div class="fileDrop"></div>
        <div id="uploadedList"></div>
    </div>
    <div style="width:700px; text-align:center;">
        <button type="button" id="btnSave">확인</button>
    </div>
</form>
</body>
</html>
