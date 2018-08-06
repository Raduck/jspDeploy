<%@page import="com.sun.org.glassfish.gmbal.ParameterNames"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp 기본객체(암묵적객체, 묵시적객체, implict object) 
	request, response
--%>
<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	String[] userIds = request.getParameterValues("userId");
	
	Map<String, String[]>requestMap = request.getParameterMap();
	String[] mapUserIds = requestMap.get("userId");
	
	Enumeration enumeration = request.getParameterNames();
	
	
%>

useId : <%= userId %> <br>
password : <%= password %>

<h2>getParameterValues</h2>
<%for(String id : userIds){%>
	userId : <%=id %><br>	
<%}%>

<h2>getParameterMap</h2>
<%for(String id : mapUserIds){%>
	userId : <%=id %><br>	
<%}%>

<h2>getParameterName</h2>
<%while(enumeration.hasMoreElements()){
	String parameterName = (String)enumeration.nextElement();	
	%>
	parameterName : <%=parameterName%>
	
<%} %>

</body>
</html>