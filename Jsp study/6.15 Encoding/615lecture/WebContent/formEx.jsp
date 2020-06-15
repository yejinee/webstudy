<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- form tag안의 action에 따라서 jsp로 보낼지 servlet으로 보낼지 달라짐  -->
	<!-- 1st예제 - post방식 -->
	<form action="mSignup.jsp" method="post">
		이름 : <input type="text" name="m_name"><br> 별명 : <input
			type="text" name="m_nickname"><br> <input type="submit"
			value="sign up">
	</form>

</body>
</html>