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
		pageContext.setAttribute("pageScope", request.getParameter("pageScope"));
		request.setAttribute("requestScope", request.getParameter("requestScope"));
		session.setAttribute("sessionScope", request.getParameter("sessionScope"));
		application.setAttribute("applicationScope", request.getParameter("applicationScope"));
	
		//값 영역의 속성으 출력해줄 결과 화면으로 위임(dispatch forward)
		RequestDispatcher re = request.getRequestDispatcher("/jsp/scope/scopeResult.jsp");
		re.forward(request, response);
	%>
</body>
</html>