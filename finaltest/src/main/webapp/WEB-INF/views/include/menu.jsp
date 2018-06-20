<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-10
  Time: 오후 6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div class="menu-bar">
    <a href="${path}/">Home</a> |
    <a href="${path}/memo/list.do">방명록</a> |
    <a href="${path}/upload/uploadAjax">업로드</a> |
    <a href="${path}/board/list.do">게시판</a> |
</div>

<div class="menu-bar-right">
    <c:choose>
        <c:when test="${sessionScope.userid == null }">
            <!-- 로그인하지 않은 상태 -->
            <a href="${path}/member/login.do">로그인</a> |
            <a href="${path}/admin/login.do">관리자 로그인</a>
        </c:when>
        <c:otherwise>
            <!-- 로그인한 상태 -->
            ${sessionScope.name}님이 로그인중입니다.
            <a href="${path}/member/logout.do">로그아웃</a>
        </c:otherwise>
    </c:choose>
</div>
<hr>
