/**
 * 
 */
 
 function fn_xlsXlsxChk(fileName) {
 
    // 문자열.split() 메소드는 문자열을 파라미터에 적은 문자로 구분하여 배열로 저장한다.
    var tmp = fileName.split(".");
    var extensionType = tmp[1];
        
    // extensionType에 담은 확장자가 'xls' 또는 'xlsx'이면 true를 리턴. 아닐 경우 false를 리턴.
    if( extensionType == "xls" ){
        return true;
    } else if( extensionType == "xlsx" ){
        return true;
    } else{
        return false;
    }
}


function regularExpression( fileName ) {
        
    // -, _, ., 숫자, 알파벳 소문자가 아니면 체크
    var checkRegExp = /^[-_.0-9a-z]*$/;
        
    // 2. 허용된 범위의 문자만 사용했다면 true를 리턴. 그 외의 문자를 사용했다면 false를 리턴.
    if ( !checkRegExp.test( fileName ) ) return false;
    else return true;
}


function fn_chkNSubmit() {
 
 	alert("버튼 작동");
 
    // input type="file"의 value는 선택한 파일의 경로!
    var filePath = $("#inputExcelFile").val();
 
    // input type="file"의 파일명은 .files[0].name 메소드를 사용
    var fileName = $("#inputExcelFile").files[0].name;
 
    // 파일명 체크 스크립트
    if ( !regularExpression( fileName ) ) {
        alert("파일명을 확인!");
        return false;
    }
 
    // 확장자 체크 스크립트
    if ( !fn_xlsXslxChk( fileName ) ) {
        alert("엑셀파일만 업로드 가능!");
        return false;
    }
 
    // 파일명을 "." 으로 나눠서 확장자를 제외한 파일명만 저장
    var tmp = fileName.split(".");
    var justFileName = tmp[0];
 
    // 파일명만 URI에 붙여서 URI를 완성한 후, action속성 추가 후 Submit!
    $("#frm").attr("action", "index.html?justFileName=" + justFileName;
    $("#frm").submit[0]();
}

$(function() {
    $("#uploadBtn").click(function() {
        fn_chkNSubmit();
    });
});

