<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  변수 선언  -->
	<%!
	String m_name;
	String m_password;
	String[] m_hobby;
	%>
	<!--  변수 가져오기  --> 
	<%
	m_name= request.getParameter("m_name");
	m_password= request.getParameter("m_pass");
	m_hobby= request.getParameterValues("m_hobby");
	%>
	
	
	<!-- 출력하기 -->
	m_name=<%= m_name%><br>
	m_password=<%= m_password%><br>
	m_hobby=<%
	for(int i=0;i<m_hobby.length; i++){
	%>
	<%=m_hobby[i] %>
	<% 
	}
	%><br>
	
</body>
</html>