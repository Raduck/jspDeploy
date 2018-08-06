<%@page import="kr.or.ddit.student.service.StudentService"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>
$(function() {
	$("table tbody tr").on("click", function() {
		//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
		//form 태그를 submit
		$("#id").val($(this).data("id"));
		$("#frm").submit();
		console.log("table tbody tr clicked : "+$(this).data("id"));
	});
});
</script>

</head>

<body>

	<%@include file="/common/top.jsp"%>
	
	<form action="/studentDetail" method="get" id="frm">
		<input type="hidden" name="id" id="id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">학생</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>학생 아이디</th>
									<th>학생 이름</th>
									<th>지명 횟수</th>
									<th>등록 일자 (yyyy-MM-dd)</th>
								</tr>
								</thead>
<%-- 								<% --%>
<!--  									List<StudentVo> studentList = (List<StudentVo>) request -->
<!--											.getAttribute("studentList"); -->
<!-- 									for (StudentVo vo1 : studentList) { -->
<!-- 									pageContext.setAttribute("vo", vo1); -->
<%-- 								%> --%>

<!-- 								<tr> -->
<%-- 									<td><%=vo1.getId()%></td> --%>
<%-- 									<td><%=vo1.getName()%></td> --%>
<%-- 									<td><%=vo1.getCall_cnt()%></td> --%>
<!-- 								</tr> -->
								<tbody>
								<c:forEach items="${studentList }" var="vo">
									<!-- 태그 클릭시 상세보기로 이동 -->
									<tr data-id="${vo.id }">
										<td>${vo.id}</td>
										<td>${vo.name}</td>
										<td>${vo.call_cnt}</td>
										<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
								</tbody>

							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>