<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
td {
	border: 1px solid red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 기본 객체 : request, response, session
		// out 객체 : servlet의 printWriter와 유사한 객체
		// localhost:8180/jsp/implict/out.jsp
		out.write("sumResult : "+session.getAttribute("sumResult"));
	%>
<table>
	<%for (int i = 1; i < 9; i++) { 
		out.write("<tr>");
		for (int j = 1; j < 9; j++){
			out.write("<td>"+ j +"*"+ i +"="+i*j+ "</td>");
		}
			out.write("</tr>");
		}
	%>
</table>


</body>
</html>