function checkImageType(fileName){
    var pattern=/jpg|gif|png|jpeg/;
    return fileName.match(pattern);
}
function getFileInfo(fullName){
    var fileName, imgsrc, getLink, fileLink;
    if(checkImageType(fullName)){ //이미지 파일인 경우
        imgsrc="/upload/displayFile?fileName="
            +fullName;
        fileLink=fullName.substr(14);
        var front=fullName.substr(0,12);
        var end=fullName.substr(14);
        getLink="/upload/displayFile?fileName="
            +front+end;
    }else{ //이미지가 아닌 경우
        fileLink=fullName.substr(12);
        getLink="/upload/displayFile?fileName="
            +fullName;
    }
    // uuid_filename
    fileName=fileLink.substr(fileLink.indexOf("_")+1);
    return {fileName: fileName, imgsrc: imgsrc,
        getLink: getLink, fullName:fullName };
}