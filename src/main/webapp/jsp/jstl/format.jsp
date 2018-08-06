<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>number</h3>
<%-- <fmt:setLocale value="de"/> --%>
<fmt:formatNumber value="${number }" type="number"/><br>
<fmt:formatNumber value="${number }" type="currency"/><br>
<fmt:formatNumber value="${number }" type="percent"/><br>
<h3>numberStr</h3>
<fmt:parseNumber value="${numberStr }"/>
<h3>date</h3>
<fmt:formatDate value="${today }" dateStyle="full"/><br>
<fmt:formatDate value="${today }" dateStyle="medium"/><br>
<fmt:formatDate value="${today }" dateStyle="short"/><br>
<fmt:formatDate value="${today }" pattern="yyyy/MM/dd"/>
<h3>date parse</h3>
<fmt:parseDate value="${todayStr }" pattern="yyyy.MM.dd"></fmt:parseDate>
<h3>timezone</h3>
<fmt:timeZone value="Europe/Zagreb">
	<fmt:formatDate value="${today }" type="both" timeStyle="full"/><br>
</fmt:timeZone>

<h3>set</h3>
<fmt:setTimeZone value="Europe/Zagreb " var="timeZone"/>
<fmt:formatDate value="${today }" timeZone="timeZone"/>

<h3>fn length</h3>
fn:length ${fn:length(todayStr) }<br>
</body>
</html>