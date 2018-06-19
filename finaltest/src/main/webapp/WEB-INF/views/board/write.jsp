<%--
  Created by IntelliJ IDEA.
  User: sumin
  Date: 2018-06-19
  Time: 오후 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
    <%@include file="../include/header.jsp" %>

    <!-- include libraries(bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js -->
    <link href="${path}/summernote/summernote.css" rel="stylesheet">
    <script src="${path}/summernote/summernote.js"></script>

    <script>
        $(function () {
            //id가 memo인 태그를 summernote로 변경
            $("#content").summernote({
                height: 150,
                width: 600
            });
        });
    </script>

    <script src="${path}/include/js/common.js"></script>
    <script>
        $(function(){
            $("#btnSave").click(function(){
                var str="";
                // uploadedList 내부의 .file 태그 각각 반복
                $("#uploadedList .file").each(function(i){
                    // console.log(i);
                    //hidden 태그 구성
                    str +=
                        "<input type='hidden' name='files["+i+"]'	value='"
                        + $(this).val()+"'>";
                });
                //폼에 hidden 태그들을 붙임
                $("#form1").append(str);
                document.form1.submit();
            });
            $(".fileDrop").on("dragenter dragover",function(e){
                e.preventDefault();
            });
            $(".fileDrop").on("drop",function(e){
                e.preventDefault();
                //첫번째 첨부파일
                var files=e.originalEvent.dataTransfer.files;
                var file=files[0];
                //폼 데이터에 첨부파일 추가
                var formData=new FormData();
                formData.append("file",file);
                $.ajax({
                    url: "${path}/upload/uploadAjax",
                    data: formData,
                    dataType: "text",
                    processData: false,
                    contentType: false,
                    type: "post",
                    success: function(data){
                        //console.log(data);
                        //data : 업로드한 파일 정보와 Http 상태 코드
                        var fileInfo=getFileInfo(data);
                        //console.log(fileInfo);
                        var html="<a href='"+fileInfo.getLink+"'>"+
                            fileInfo.fileName+"</a><br>";
                        html += "<input type='hidden' class='file' value='"
                            +fileInfo.fullName+"'>";
                        $("#uploadedList").append(html);
                    }
                });
            });
        });
    </script>
    <style>
        .fileDrop{
            width: 600px;
            height: 100px;
            border: 1px dotted gray;
            background-color: gray;
        }
    </style>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<h2>글쓰기</h2>
<form id="form1" name="form1" method="post" action="${path}/board/insert.do">
    <div>
        제목 <input name="title" id="title" size="80" placeholder="제목을 입력하세요">
    </div>
    <div style="width:800px;">
        내용<textarea id="content" name="content" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
    </div>
    <div>첨부파일
        <div class="fileDrop"></div>
        <div id="uploadedList"></div>
    </div>
    <div style="width:700px; text-align:center;">
        <button type="button" id="btnSave">확인</button>
    </div>
</form>
</body>
</html>
