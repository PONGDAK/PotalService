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
<div style="text-align: center;">
    <a href="${path}/">Home</a>
    <a href="${path}/member/list.do">회원관리</a>
    <a href="${path}/memo/list.do">메모장</a>
</div>
<hr>
