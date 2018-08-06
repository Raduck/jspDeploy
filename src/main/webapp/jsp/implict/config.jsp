<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//localhost:8180/jsp/implict/config.jsp
	//jsp 기본객체 : request, response, session, out, application
	//config : 설정 --> application을 통해서 대체 가능
	config.getInitParameter("ADMIN_USER");


%>
config.getInitParameter("ADMIN_USER") : <%=config.getInitParameter("ADMIN_USER") %><br>
application.getInitParameter("ADMIN_USER") : <%=application.getInitParameter("ADMIN_USER") %>
</body>
</html>