<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- error 발생시 errorPage.jsp로 보냄 --%>
<%@ page errorPage="errorPage.jsp" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 변수 선언 --%>
	<%!
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	String realServerIP;
	
	String str;
	%>
	
	<%-- Config객체 이용해서 web.xml에서 정의한 변수 가져오기--%>
	<%
	adminId=config.getInitParameter("adminId");
	adminPw=config.getInitParameter("adminPw");
	%>
	<%-- 화면에 출력  --%>
	<p> adminId: <%=adminId %></p>
	<p> adminPw: <%=adminPw %></p>
	
	<%-- Application 객체 이용해서 web.xml에서 정의한 변수 가져오기 --%>
	<% 
	imgDir=application.getInitParameter("imgDir");
	testServerIP=application.getInitParameter("testServerIP");
	realServerIP=application.getInitParameter("realServerIP");
	%>
	
	<p> imgDir: <%=imgDir %></p>
	<p> testServerIP: <%=testServerIP %></p>
	<p> realServerIP: <%=realServerIP %></p>
	
	<%
	application.setAttribute("connectedIp", "165.62.58.23");
	application.setAttribute("connectedUser", "hong");
	%>
	
	<%-- out 객체  --%>
	<%
		out.print("<h1>Hello Java</h1>");
	%>
	
	<%-- exception 객체 : 초기화 하지 않고 실행시키면 error발생하게 함 
	-> errorpage실행    	--%>
	
	<%
		out.print(str.toString());
	%>
	
	
</body>
</html>