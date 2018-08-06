<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	작성된 msg 파일
	msg.properties
	msg_ko.properties
	msg_en.properties
	msg_ja.properties


 --%>
 
 <c:set var="userId" value="brown"/>
 
 <%--setLoate 태그를 통해 임의로 로케이트를 수정 --%>
 <fmt:setLocale value="ja"/>
 <fmt:bundle basename="kr.or.ddit.msg.msg">
 	<fmt:message key="hello"></fmt:message>
 	<fmt:message key="visitor">
 		<fmt:param value="${userId }"></fmt:param>
 	</fmt:message>
 </fmt:bundle>
 
 
 <h3>setBundle</h3>
 <fmt:setLocale value="en"/>
 <fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
 <fmt:message bundle="${msg }" key="hello"/> <br>
 <fmt:message bundle="${msg }" key="visitor">
 	<fmt:param value="${userId }"/>
 </fmt:message>
 
 
</body>
</html>