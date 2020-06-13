<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 실제 cookie가 제대로 전송 되었는지 확인 -->
	<%
		Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		out.print("name: " + c.getName() + "<br>");
		out.print("value: " + c.getValue() + "<br>");
		out.print("------------------------------");
	}
	%>
</body>
</html>