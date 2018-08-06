<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition",  // 타일 관련
			"attachment; filename=excel.xls"); // 파일이름
	response.setHeader("Content-Description", "JSP Generated Data"); // 주석 정도로 생각하면됨
	response.setContentType("application/vnd.ms-excel"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>userId</td>
			<td>password</td>
		</tr>
		<tr>
			<td>brown</td>
			<td>1234</td>
		</tr>
		<tr>
			<td>sally</td>
			<td>1234</td>
		</tr>
	</table>
</body>
</html>