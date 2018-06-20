<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-20
  Time: 오후 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<div class="container">
    <div class="content">
        <h2>회원등록</h2>
        <form name="form1" method="post"
              action="${path}/management/insert.do">
            <table border="1" width="400px">
                <tr>
                    <td>아이디</td>
                    <td><input name="userid"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="passwd"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input name="name"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input name="email"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="확인"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>