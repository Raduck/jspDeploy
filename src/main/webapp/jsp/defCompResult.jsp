<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 파라미터 값 확인 --%>
<%-- ${defComp } : 속성에서 값 확인--%>
<%-- ${param.defComp} : request객체의 파라미터 값 확인--%>
<%-- ${cookies.defComp } : cookie 값 확인 --%>
request.defComp : ${param.defComp}
</body>
</html>