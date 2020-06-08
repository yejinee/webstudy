<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 기본값 false이기 때문에 errorpage로 사용할거라고 명시해줘야함 -->
<%@ page isErrorPage='true' %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--  어떤 exception인지에 대한 내용 출력  -->
	<%
		response.setStatus(200);
		String msg=exception.getMessage();
	%>
	
	<h1> error message : <%= msg %></h1>



</body>
</html>