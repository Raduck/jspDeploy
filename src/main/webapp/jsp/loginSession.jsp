<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
SessionAttributeListener을 통해 로그인시 application 객체에
loginSessionMap 객체를 속성으로 저장

loginSessionMap을 loop을 돌며 데이터를 출력
 --%>
 
 loginSession count : [${loginSessionMap.size()}]
 
 <c:forEach items="${loginSessionMap }" var="vo">
 	${vo.key} / ${vo.value }<br>
 </c:forEach>
 
</body>
</html>