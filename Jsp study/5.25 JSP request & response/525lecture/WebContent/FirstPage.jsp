<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  second page �� ������ ������ ���� (response ) -->
	<p> First Page!! </p>
	<% 
		response.sendRedirect("SecondPage.jsp");
	%>

<!--  ������ Sencond.jsp page�� ���±� ������ ���� �ÿ� FirstPage�� �ƴ� Second Page�� ��µȴ�. -->

</body>
</html>