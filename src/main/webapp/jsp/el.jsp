<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>request</h3>
	표현식 :
	<%=request.getAttribute("requestScop")%>
	<br> EL : ${requestScope.requestScop }
	<br> EL : ${requestScop}
	<br>

	<h3>session</h3>
	표현식 :
	<%=session.getAttribute("sessionScop")%>
	<br> EL : ${sessionScope.sessionScop }
	<br> EL : ${sessionScop }
	<br>
	<h3>application</h3>
	표현식 :
	<%=application.getAttribute("applicationScop")%>
	EL : ${applicationScope.applicationScop }
	<br> EL : ${applicationScop }
	<br>

	<h3>sameName</h3>
	EL : ${sameName } 어떤 영역의 값을 가져오나? --> 가장 작은 영역에서 부터 큰 영역으로 검색
	<br> pageContext -> request --> session -> application
	<br>

	<h3>studentList</h3>
	표현식 :
	<%=request.getAttribute("studentList")%>
	<%-- EL : ${studentList } --%>
	<br>

	<%-- <table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>call_cnt</th>
		</tr>

		<%
			List<StudentVo> studentList = (List<StudentVo>)request.getAttribute("studentList");
		%>
		<%
			for(StudentVo vo : studentList){
		%>
		pageContext.setAttribute("vo",vo)
		<td><%=vo.getId()%></td>
		<td><%=vo.getName()%></td>
		<td><%=vo.getCall_cnt()%></td>
		<%
			}
		%>

	</table> --%>

	<%-- EL : ${studentList } --%>
	<br>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>call_cnt</th>
		</tr>
		<c:forEach items="${studentList}" var="vo">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.call_cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>