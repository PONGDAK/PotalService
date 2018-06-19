<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-19
  Time: 오후 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글보기</title>
    <%@include file="../include/header.jsp" %>
    <!-- include libraries(bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js -->
    <link href="${path}/summernote/summernote.css" rel="stylesheet">
    <script src="${path}/summernote/summernote.js"></script>

    <script>
        $(function () {
            $("#content").summernote({
                height: 500,
                width: 800
            });
        });
    </script>

    <script src="${path}/include/js/common.js"></script>
    <script>
        $(function () {

            listReply2();

            //댓글 쓰기
            $("#btnReply").click(function () {
                var replytext = $("#replytext").val(); //댓글 내용
                var id = "${dto.id}"; //게시물 번호
                var param = {"replytext": replytext, "id": id};
                //var param="replytext="+replytext+"&id="+id;
                $.ajax({
                    type: "post",
                    url: "${path}/reply/insert.do",
                    data: param,
                    success: function () {
                        alert("댓글이 등록되었습니다.");
                        listReply2(); //댓글 목록 출력
                    }
                });
            });

            $(".fileDrop").on("dragenter dragover", function (e) {
                //기본 효과 막음
                e.preventDefault();
            });
            $(".fileDrop").on("drop", function (e) {
                e.preventDefault();
                //첫번째 첨부파일
                var files = e.originalEvent.dataTransfer.files;
                var file = files[0];
                //폼 데이터에 첨부파일 추가
                var formData = new FormData();
                formData.append("file", file);
                $.ajax({
                    url: "${path}/upload/uploadAjax",
                    data: formData,
                    dataType: "text",
                    processData: false,
                    contentType: false,
                    type: "post",
                    success: function (data) {
                        //console.log(data);
                        //data : 업로드한 파일 정보와 Http 상태 코드
                        var fileInfo = getFileInfo(data);
                        //console.log(fileInfo);
                        var html = "<a href='" + fileInfo.getLink + "'>" +
                            fileInfo.fileName + "</a><br>";
                        html += "<input type='hidden' class='file' value='"
                            + fileInfo.fullName + "'>";
                        $("#uploadedList").append(html);
                    }
                });
            });

//목록 버튼
            $("#btnList").click(function () {
                location.href = "${path}/board/list.do";
            });
            //수정 버튼
            $("#btnUpdate").click(function () {
                //첨부파일 이름들을 폼에 추가
                var str = "";
                $("#uploadedList .file").each(function (i) {
                    str +=
                        "<input type='hidden' name='files[" + i + "]' value='"
                        + $(this).val() + "'>";
                });
                $("#form1").append(str);
                document.form1.action = "${path}/board/update.do";
                document.form1.submit();
            });
            //삭제 버튼
            $("#btnDelete").click(function () {
                if (confirm("삭제하시겠습니까?")) {
                    document.form1.action = "${path}/board/delete.do";
                    document.form1.submit();
                }
            });

            listAttach();

            //첨부파일 삭제
            //id가 uploadedList인 태그의 class가 file_del인 태그 클릭
            $("#uploadedList").on("click", ".file_del", function (e) {
                var that = $(this); //클릭한 태그
//data: {fileName: $(this).attr("data-src") },
                $.ajax({
                    type: "post",
                    url: "${path}/upload/deleteFile",
                    data: "fileName=" + $(this).attr("data-src"),
                    dataType: "text",
                    success: function (result) {
                        if (result == "deleted") {
                            //화면에서 태그 제거
                            that.parent("div").remove();
                        }
                    }
                });
            });

            $("#btnSave").click(function () {
                var str = "";
                // uploadedList 내부의 .file 태그 각각 반복
                $("#uploadedList .file").each(function (i) {
                    console.log(i);
                    //hidden 태그 구성
                    str +=
                        "<input type='hidden' name='files[" + i + "]'	value='"
                        + $(this).val() + "'>";
                });
                //폼에 hidden 태그들을 붙임
                $("#form1").append(str);
                document.form1.submit();
            });

        });

        //댓글 목록 출력 함수
        function listReply() {
            $.ajax({
                type: "get",
                url: "${path}/reply/list.do?id=${dto.id}",
                success: function (result) {
                    //result : responseText 응답텍스트(html)
                    $("#listReply").html(result);
                }
            });
        }

        //타임스탬프값(숫자형)을 문자열 형식으로 변환
        function changeDate(date) {
            date = new Date(parseInt(date));
            year = date.getFullYear();
            month = date.getMonth();
            day = date.getDate();
            hour = date.getHours();
            minute = date.getMinutes();
            second = date.getSeconds();
            strDate =
                year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
            return strDate;
        }

        function listReply2() {
            $.ajax({
                type: "get",
                contentType: "application/json",
                url: "${path}/reply/list_json.do?id=${dto.id}",
                success: function (result) {
                    console.log(result);
                    var output = "<table>";
                    for (var i in result) {
                        var repl = result[i].replytext;
                        repl = repl.replace(/  /gi, "&nbsp;&nbsp;");//공백처리
                        repl = repl.replace(/</gi, "&lt;"); //태그문자 처리
                        repl = repl.replace(/>/gi, "&gt;");
                        repl = repl.replace(/\n/gi, "<br>"); //줄바꿈 처리

                        output += "<tr><td>" + result[i].name;
                        date = changeDate(result[i].post_date);
                        output += "(" + date + ")";
                        output += "<br>" + repl + "</td></tr>";
                    }
                    output += "</table>";
                    $("#listReply").html(output);
                }
            });
        }

        //첨부파일 리스트를 출력하는 함수
        function listAttach() {
            $.ajax({
                type: "post",
                url: "${path}/board/getAttach/${dto.id}",
                success: function (list) {
                    // list : json
                    //console.log(list);
                    $(list).each(function () {
                        var fileInfo = getFileInfo(this);
                        //console.log(fileInfo);
                        var html = "<div><a href='" + fileInfo.getLink + "'>"
                            + fileInfo.fileName + "</a>&nbsp;&nbsp;";
                        <c:if test="${sessionScope.id == dto.id_member}">
                        html += "<a href='#' class='file_del' data-src='"
                            + this + "'>[삭제]</a></div>";
                        </c:if>
                        $("#uploadedList").append(html);
                    });
                }
            });
        }


    </script>
    <style>
        .fileDrop {
            width: 600px;
            height: 100px;
            border: 1px dotted gray;
            background-color: gray;
        }
    </style>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>게시글보기</h2>
<form id="form1" name="form1" method="post" action="${path}/board/insert.do">
    <div>
        제목 <input name="title" id="title" size="80" value="${dto.title}" placeholder="제목을 입력하세요">
    </div>
    <div>조회수 : ${dto.view_count}</div>
    <div style="width:800px;">
        내용<textarea id="content" name="content" rows="3" cols="80" placeholder="내용을 입력하세요">${dto.content}</textarea>
    </div>
    <div>첨부파일
        <div class="fileDrop"></div>
        <div id="uploadedList"></div>
    </div>
    <div style="width:700px; text-align:center;">
        <input type="hidden" name="id" value="${dto.id}">
        <c:if test="${sessionScope.id == dto.id_member}">
            <button type="button" id="btnUpdate">수정</button>
            <button type="button" id="btnDelete">삭제</button>
        </c:if>
        <button type="button" id="btnList">목록으로</button>
    </div>
</form>
</body>
</html>