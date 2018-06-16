<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-16
  Time: 오후 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../include/header.jsp" %>
    <script type="text/javascript">
        $(function(){
            $("#btnUpdate").click(function(){
                document.form1.action="${path}/memo/update/${dto.id}";
                document.form1.submit();
            });
            $("#btnDelete").click(function(){
                if(confirm("삭제하시겠습니까?")){
                    document.form1.action="${path}/memo/delete/${dto.id}";
                    document.form1.submit();
                }
            });
        });
    </script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모 보기</h2>
<form name="form1" method="post">
    <table border="1" width="500px">
        <tr>
            <td>번호</td>
            <td>${dto.id}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input name="writer" value="${dto.writer}"></td>
        </tr>
        <tr>
            <td>메모</td>
            <td><%-- <input name="memo" value="${dto.memo}" size="50"> --%>
                <textarea rows="5" cols="60"
                          name="memo" id="memo">${dto.memo}</textarea>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="hidden" name="idx" value="${dto.id}">
                <input type="button" value="수정" id="btnUpdate">
                <input type="button" value="삭제" id="btnDelete">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
