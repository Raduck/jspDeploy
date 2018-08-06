<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action=<%application.getContextPath();%>"/sumCalculation" method="post">
		<label for="start">Start</label> 
		<input type="text" id="start" name="start"> 
		<label for="end">End</label>
		<input type="text" id="end" name="end">
		<button type="submit">Go</button>
	</form>
</body>
</html>