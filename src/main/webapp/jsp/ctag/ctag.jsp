<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>logging</h3>
	<tags:logging />
	<br>
	<c:forEach items="${studentList }" var="student">
      ${student.id} / 
      ${student.name} / 
      ${student.call_cnt} / 
      <fmt:formatDate value="${student.reg_dt }" pattern="yyyy-MM-dd" />
		<br>
	</c:forEach>
	<br>
	
	<h3>colorLogging</h3>
	<tags:colorLogging color="blue" /><br>
	<c:forEach items="${studentList }" var="student">
      ${student.id} / 
      ${student.name} / 
      ${student.call_cnt} / 
      <fmt:formatDate value="${student.reg_dt }" pattern="yyyy-MM-dd" />
		<br>
	</c:forEach>
	<tags:colorLogging color="red" /><br>
	
	
	<tags:colorLogging color="blue" /><br>
	<tags:prodSelect lgu='p101'/>
	
	<tags:colorLogging color="red" />
	
	
	
	
	
</body>
</html>