<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- views/member/login.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@ include file="../include/header.jsp" %>
    <script>
        $(function () {
            $("#btnLogin").click(function () {
                var userid = $("#userid").val(); //태그의 value 속성값
                var passwd = $("#passwd").val();
                if (userid == "") {
                    alert("아이디를 입력하세요.");
                    $("#userid").focus(); //입력 포커스 이동
                    return; //함수 종료
                }
                if (passwd == "") {
                    alert("비밀번호를 입력하세요.");
                    $("#passwd").focus();
                    return;
                }
                //폼 데이터를 서버로 제출
                document.form1.action = "${path}/member/loginCheck.do";
                document.form1.submit();
            });
        });
    </script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<div class="container">
    <div class="content">
        <h2>로그인</h2>
        <form name="form1" method="post">
            <div class="login-table">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input name="userid" id="userid"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="passwd" id="passwd"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="button" id="btnLogin" value="로그인">

                            <c:if test="${param.message == 'nologin' }">
                                <div style="color:red;">
                                    로그인 하신 후 사용하세요.
                                </div>
                            </c:if>
                            <c:if test="${message == 'error' }">
                                <div style="color:red;">
                                    아이디 또는 비밀번호가 일치하지 않습니다.
                                </div>
                            </c:if>
                            <c:if test="${message == 'logout' }">
                                <div style="color:blue;">
                                    로그아웃 처리되었습니다.
                                </div>
                            </c:if>
                            <h3>${text}</h3>
                            <div>
                                <a href="${path}/member/signin.do">아이디가 없으신가요? 지금 가입하세요.</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>



















