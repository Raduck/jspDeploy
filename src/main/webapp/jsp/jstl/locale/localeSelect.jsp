<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/jquery.jsp"%>
<script type="text/javascript">
	//select box 변경시 요청이 되도록 수정
	$(function() {
		$("select[name=locale]").val("${locale}").prop("selected", true);

		//select box 변경 이벤트
		$("select[name=locale]").on("change", function() {
			console.log("selectbox change");
			$("form").submit();
		})
	})
</script>
</head>
<body>
	<c:set var="userId" value="brown" />
	<form action="/localeServlet" method="get">
		<select name="locale" id="locale">
			<option value="ko" ${locale eq 'ko' ? "selected" : '' }>한국어</option>
			<option value="en" ${locale eq 'en' ? "selected" : '' }>English</option>
			<option value="ja" ${locale eq 'ja' ? "selected" : '' }>日本語</option>
		</select>
	</form>
	<fmt:setLocale value="${locale }" />
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"></fmt:message>
		<fmt:message key="visitor">
			<fmt:param value="${userId }"></fmt:param>
		</fmt:message>
	</fmt:bundle>
</body>
</html>