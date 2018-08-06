<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td {
	border: 1px solid red;
}
</style>
</head>
<body>
	<!-- <% %>: 스크립틀릿 -->
	<!-- : 스크립틀릿 -->
	<%
	//이부분에서 자바코드 작성 방법이 적용된다.
	Date dt =new Date(); 
	//yyyy-mm-dd
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	%>
	

	hello servlet world
	<br> current time :
	<%=sdf.format(dt) %>
	<table>
	<%-- <%
	
		for (int i = 1; i < 9; i++) {
			
			out.print("<tr>");
			out.print("<td>"+i+"단</td>");//
			for (int j = 1; j < 9; j++) {
				
				out.print("<td>"+i+"*"+j+"="+i*j+"</td>");
			}
			out.print("</tr>");
		}
		
	 %> --%>
	 
	 <%for (int i = 1; i < 9; i++) { %>
	 	<tr>
	 	<% for (int j = 1; j < 9; j++) {  %>
	 	<!-- html -->
	 		<td> <%=j %>*<%=i %>=<%=i*j %></td>
	 	<%} %>
	 	</tr>
	 <%} %>
</tr>
</table>
</body>
</html>

<!-- 
	localhost:8180/jsp/basic.jsp

 -->