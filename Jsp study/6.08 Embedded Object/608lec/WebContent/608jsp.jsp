<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- error �߻��� errorPage.jsp�� ���� --%>
<%@ page errorPage="errorPage.jsp" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- ���� ���� --%>
	<%!
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	String realServerIP;
	
	String str;
	%>
	
	<%-- Config��ü �̿��ؼ� web.xml���� ������ ���� ��������--%>
	<%
	adminId=config.getInitParameter("adminId");
	adminPw=config.getInitParameter("adminPw");
	%>
	<%-- ȭ�鿡 ���  --%>
	<p> adminId: <%=adminId %></p>
	<p> adminPw: <%=adminPw %></p>
	
	<%-- Application ��ü �̿��ؼ� web.xml���� ������ ���� �������� --%>
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
	
	<%-- out ��ü  --%>
	<%
		out.print("<h1>Hello Java</h1>");
	%>
	
	<%-- exception ��ü : �ʱ�ȭ ���� �ʰ� �����Ű�� error�߻��ϰ� �� 
	-> errorpage����    	--%>
	
	<%
		out.print(str.toString());
	%>
	
	
</body>
</html>