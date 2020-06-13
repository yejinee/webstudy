<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  cookie가 있는지 없는지 확인 해야함 -> cookie가 있다면 로그인 페이지 나올 필요 없음 -->
	<%
		Cookie[] cookies = request.getCookies();
	System.out.println("cookies :" + cookies);

	if (cookies != null) {
		for (Cookie c : cookies) {
			// id가 있으면(이미 로그인 되어있음) 바로 결과 페이지로 이동해 줄 것 
			if (c.getName().equals("memberId")) {
		response.sendRedirect("loginOk.jsp");
			}
		}
	}
	%>



	<form action="loginCon" method="post">
		ID : <input type="text" name="mID"><br> PW : <input
			type="password" name="mPW"><br> <input type="submit"
			value="login">
	</form>
</body>
</html>