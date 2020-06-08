<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%! String connectedIp;
		String connectedUser;
	%>
	
	<!--  Application 객체 -->
	<% 
	connectedIp=(String)application.getAttribute("connectedIp");
	connectedUser=(String)application.getAttribute("connectedUser");
	%>

	<p> connectedIP : <%= connectedIp %></p>
	<p> connectedUser : <%= connectedUser %></p>
	
</body>
</html>