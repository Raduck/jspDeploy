<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
td,th {
	border: 1px solid green;
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Object bv = session.getAttribute("boardList"); 
		List<BoardVo> bl = (List<BoardVo>)bv;
		
	%>
	
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>사용자 아이디</th>
				<th>별명</th>
				<th>등록일(yyyy-MM-dd)</th>
			</tr>
		</thead>
	
	</table>
	
	<tbody>
	<%-- <%SimpleDateFormat sdf=SimpleDateFormat("yyyy-MM-dd"); %> --%>
	<%for(int i=0; i<bl.size(); i++){ %>
		<tr>
			<td><%=bl.get(i).getTitle() %></td>
			<td><%=bl.get(i).getUserId() %></td>
			<td><%=bl.get(i).getClass() %></td>
			<td><%=bl.get(i).getRegDt().toString() %></td>
		</tr>
	<%} %>
	</tbody>
</body>
</html>