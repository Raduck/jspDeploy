<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(function() {
	//주소찾기 버튼 클릭 이벤트
	$("#findAddr").click(function() {
		 new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            $("#addr1Label").text(data.address);
		            $("#zipcdLabel").text(data.address);
		            $("#zipcdInput").val(data.zonecode);
		            $("#addr1Input").val(data.zonecode);
		            //상세주소 변경
		            $("#addr2").val("");
		          //console.log(data.zonecode);
		          //console.log(data.address);
		        }
		    }).open();
		 });
		 //학생 수정 버튼 클릭 이벤트
		 $("#updateBtn").on("click",function(){
				//학생 이름, 상세 주소
				if($("#name").val().length < 2){
					alert("학생이름을 입력해주세요");
					$("#name").focus();
					return false;
				}
				if($("#addr2").val().length < 2){
					alert("상세주소를 입력해주세요");
				 $("#addr2").focus();
				 return false;
			 }
			//여기까지 전달되면 validation 통과 --> submit
			//console.log($("#frm").serialize());
			$("#frm").submit();
		});
});

   
</script>
</head>

<body>
	<%@include file="/common/top.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" 
				action="/studentUpdate" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?id=${studentVo.id}">
							<input type="file" name="pic">
						</div>
					</div>
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.id}</label>
							<input type="hidden" class="form-control" id="id" name="id"
								value="${studentVo.id }" placeholder="학생 아이디">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								value="${studentVo.name }" placeholder="학생 이름">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">호출 횟수</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-10">
							<label id="addr1Label" class="control-label">${studentVo.addr1 }</label>
							<input id="addr1Input" type="hidden" name="addr1" value="${studentVo.addr1 }">
							<button type="button" id="findAddr">주소 찾기</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addr2" name="addr2"
								value="${studentVo.addr2 }" placeholder="상세 주소">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편 번호</label>
						<div class="col-sm-10">
							<label id="zipcdLabel" class="control-label">${studentVo.zipcd }</label>
							<input id="zipcdInput" type="hidden" name="zipcd" value="${studentVo.zipcd }">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">가입 일</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.reg_dt }</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
