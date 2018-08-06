<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- factorial method
		0! : 1
		1! : 1 = 1
		2! : 2 * 1 = 2
		3! : 3 * 2 * 1 = 6
		4! : 4 * 3 * 2 * 1 * = 24
 --%>
<%!
public int factorial(int fac){
	if(fac<0)
		return 0;
	else if (fac < 2)
		return 1;
	else
		return fac*factorial(fac-1);
}
%>
factorial(-1) :<%=factorial(-1) %><br>
factorial(0) :<%=factorial(0) %><br>
factorial(3) :<%=factorial(3) %><br>
factorial(4) :<%=factorial(4) %><br>
factorial(5) :<%=factorial(5) %><br>
factorial(6) :<%=factorial(6) %><br>
factorial(7) :<%=factorial(7) %><br>

<% for(int i = 1; i < 9; i++){ %>
	<!-- out.print(factorial(i)); -->
	factorial(<%=i%>) = <%=factorial(i) %> <br>
<%	}%>


</body>
</html>