<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-19
  Time: 오전 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <%@include file="../include/header.jsp" %>
    <script>
        $(function () {
            $("#btnWrite").click(function () {
                location.href = "${path}/board/write.do";
            });
        });
        function list(page){
            location.href="${path}/board/list.do?currentPage="+page;
        }

    </script>

</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시판</h2>
<button type="button" id="btnWrite">글쓰기</button>
${map.count}개의 게시글이 있습니다.
<script>
    console.log(${map.pager.totalBlock})
</script>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>날짜</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="row" items="${map.list}">
        <tr>
            <td>${row.id}</td>
            <td>${row.title}</td>
            <td>${row.name}</td>
            <td><fmt:formatDate value="${row.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${row.view_count}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5" align="center">
            <c:if test="${map.pager.currentBlock > 1}">
                <a href="#" onclick="list('1')">[처음]</a>
            </c:if>
            <c:if test="${map.pager.currentBlock > 1}">
                <a href="#" onclick="list('${map.pager.previousPage}')">
                    [이전]</a>
            </c:if>
            <c:forEach var="num"
                       begin="${map.pager.beginBlock}"
                       end="${map.pager.endBlock}">
                <c:choose>
                    <c:when test="${num == map.pager.currentPage}">
                        <!-- 현재 페이지인 경우 하이퍼링크 제거 -->
                        <span style="color:red;">${num}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="#" onclick="list('${num}')">${num}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${map.pager.currentBlock < map.pager.totalBlock}">
                <a href="#"
                   onclick="list('${map.pager.nextPage}')">[다음]</a>
            </c:if>
            <c:if test="${map.pager.currentPage < map.pager.totalPage}">
                <a href="#"
                   onclick="list('${map.pager.totalPage}')">[끝]</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
