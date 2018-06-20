<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-20
  Time: 오후 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@ include file="../include/header.jsp" %>
    <script>
        $(function () {
            $("#btnUpdate").click(function () {
                if (confirm("수정하시겠습니까?")) {
                    document.form1.action = "${path}/management/update.do";
                    document.form1.submit();
                }
            });
            $("#btnDelete").click(function () {
                if (confirm("삭제하시겠습니까? 탈퇴예정으로 변경됩니다.")) {
                    document.form1.action = "${path}/management/delete.do";
                    document.form1.submit();
                }
            });
            $("#btnCancel").click(function () {
                if (confirm("탈퇴가 취소되었습니다.")) {
                    document.form1.action = "${path}/management/cancel.do";
                    document.form1.submit();
                }
            });
            $("#btnDeleteNow").click(function () {
                if (confirm("정말 완전 삭제하시겠습니까? 게시물 및 댓글이 전부 삭제됩니다.")) {
                    document.form1.action = "${path}/management/deletenow.do";
                    document.form1.submit();
                }
            });
        });
    </script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<div class="container">
    <div class="content">
        <h2>회원정보 수정</h2>
        <form name="form1" method="post">
            <table border="1" width="400px">
                <tr>
                    <td>회원코드</td>
                    <td><input name="id" value="${dto.id}" readonly></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input name="userid" value="${dto.userid}"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="passwd"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input name="name" value="${dto.name}"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input name="email" value="${dto.email}"></td>
                </tr>
                <tr>
                    <td>회원가입일자</td>
                    <td>
                        <c:if test="${join_date != null }">
                            <fmt:formatDate value="${join_date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>

                        <fmt:formatDate value="${dto.join_date}"
                                        pattern="yyyy-MM-dd HH:mm:ss"/>

                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="수정" id="btnUpdate">
                        <c:if test="${dto.cancel=='N'}">
                        <input type="button" value="삭제" id="btnDelete">
                        </c:if>
                        <c:if test="${dto.cancel=='Y'}">
                            <input type="button" value="탈퇴취소" id="btnCancel">
                            <input type="button" value="지금삭제" id="btnDeleteNow">
                        </c:if>
                        <div style="color: red;">${message}</div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

