<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-16
  Time: 오후 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${path}/">회원관리</a> |
<a href="${path}/upload/uploadAjax">업로드 테스트</a> |
<a href="${path}/board/list.do">게시판</a>

<div style="text-align:right;">
    <c:choose>
        <c:when test="${sessionScope.admin_userid == null }">
            <!-- 로그인하지 않은 상태 -->
            <a href="${path}/admin/login.do">관리자 로그인</a>
        </c:when>
        <c:otherwise>
            <!-- 로그인한 상태 -->
            ${sessionScope.admin_name}님이 로그인중입니다.
            <a href="${path}/admin/logout.do">로그아웃</a>
        </c:otherwise>
    </c:choose>
</div>
<hr>
