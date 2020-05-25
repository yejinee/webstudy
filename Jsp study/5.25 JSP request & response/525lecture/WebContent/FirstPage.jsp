<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  second page 로 정보를 보내는 예제 (response ) -->
	<p> First Page!! </p>
	<% 
		response.sendRedirect("SecondPage.jsp");
	%>

<!--  응답을 Sencond.jsp page로 보냈기 때문에 실행 시에 FirstPage가 아닌 Second Page가 출력된다. -->

</body>
</html>