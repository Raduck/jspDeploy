<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-1.12.4.js"></script>
<script>
	$(document).ready(function() {
		$('#locale').change(function(){
			alert("sss");
			$("form").submit();       
        });
		alert("sss");
	});

	/*  function chageLangSelect() {
		////////////////////////////////////////////////////임시
		//var langSelect = document.getElementById("localeSelect");
		alert("sss");
		// select element에서 선택된 option의 value가 저장된다. //////////////임시
		//var selectValue = langSelect.options[langSelect.selectedIndex].value;
		document.LocaleServlet.submit();
		//$("#localeForm").submit();
		  // select element에서 선택된 option의 text가 저장된다.
		 var selectText = langSelect.options[langSelect.selectedIndex].text;
		alert("sss");
	} 
	*/
</script>
</head>

<body>
	<form action="/localeServlet" class="localeForm" name="localeForm" method="post">
		<c:set var="userId" value="brown" />

		<select name="locale" id="locale"
			onchange="chageLangSelect()">
			<option value="ko" ${locale eq 'ko' ? "selected" : '' }>한국어</option>
			<option value="en" ${locale eq 'en' ? "selected" : '' }>English</option>
			<option value="ja" ${locale eq 'ja' ? "selected" : '' }>日本語</option>
			<option value="" ${locale eq '' ? "selected" : '' }></option>
		</select>
		<fmt:setLocale value="${param.locale }" />
		<fmt:bundle basename="kr.or.ddit.msg.msg">
			<fmt:message key="hello"></fmt:message>
			<fmt:message key="visitor">
				<fmt:param value="${userId }"></fmt:param>
			</fmt:message>
		</fmt:bundle>
		<button type="submit">전송</button>
	</form>
</body>

</html>