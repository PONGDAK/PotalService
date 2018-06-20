<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-10
  Time: 오후 6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var = "path" value ="${pageContext.request.contextPath}" />
<script src = "${path}/include/jquery-3.3.1.min.js"></script>
<%--<script src = "http://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
<link rel="stylesheet" href="${path}/include/style.css">
<!-- include libraries(bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>